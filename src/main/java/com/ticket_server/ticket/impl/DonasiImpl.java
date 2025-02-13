package com.ticket_server.ticket.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.repository.DonasiRepository;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DonasiImpl implements DonasiService {
    private static final String BASE_URL = "https://s3.lynk2.co/api/s3";
    private final DonasiRepository donasiRepository;
    private final AdminRepository adminRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public DonasiImpl(DonasiRepository donasiRepository, AdminRepository adminRepository) {
        this.donasiRepository = donasiRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Donasi> getAllDonasi() {
        return donasiRepository.findAll();
    }

    @Override
    public Optional<Donasi> getDonasiById(Long id) {
        return donasiRepository.findById(id);
    }

    @Override
    public DonasiDTO tambahDonasi(Long idAdmin, DonasiDTO donasiDTO) {
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin not found"));

        Donasi donasi = new Donasi();
        donasi.setAdmin(admin);
        donasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        donasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        donasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        donasi.setFotoUrl(donasiDTO.getFotoUrl());
        donasi.setDeskripsi(donasiDTO.getDeskripsi());

        Donasi savedDonasi = donasiRepository.save(donasi);

        DonasiDTO result = new DonasiDTO(savedDonasi);
        result.setIdAdmin(idAdmin);
        return result;
    }

    @Override
    public DonasiDTO editDonasi(Long id, Long idAdmin, String donasiJson, MultipartFile foto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DonasiDTO donasiDTO = objectMapper.readValue(donasiJson, DonasiDTO.class);

        Donasi existingDonasi = donasiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Donasi tidak ditemukan"));

        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin dengan ID " + idAdmin + " tidak ditemukan"));

        existingDonasi.setAdmin(admin);
        existingDonasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        existingDonasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        existingDonasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        existingDonasi.setDeskripsi(donasiDTO.getDeskripsi());

        if (foto != null && !foto.isEmpty()) {
            String fotoUrl = uploadFoto(foto);
            existingDonasi.setFotoUrl(fotoUrl);
        }

        Donasi updatedDonasi = donasiRepository.save(existingDonasi);
        return new DonasiDTO(updatedDonasi);
    }

    @Override
    public String uploadFoto(MultipartFile file) throws IOException {
        String uploadUrl = BASE_URL + "/uploadFoto";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(uploadUrl, HttpMethod.POST, requestEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return extractFileUrlFromResponse(response.getBody());
        } else {
            throw new IOException("Failed to upload file: " + response.getStatusCode());
        }
    }

    private String extractFileUrlFromResponse(String responseBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(responseBody);
        JsonNode dataNode = jsonResponse.path("data");
        return dataNode.path("url_file").asText();
    }

    @Override
    public void deleteDonasi(Long id) {
        if (!donasiRepository.existsById(id)) {
            throw new NotFoundException("Donasi tidak ditemukan");
        }
        donasiRepository.deleteById(id);
    }
}