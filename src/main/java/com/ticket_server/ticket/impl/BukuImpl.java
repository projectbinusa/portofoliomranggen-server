package com.ticket_server.ticket.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.repository.BukuRepository;
import com.ticket_server.ticket.service.BukuService;
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
public class BukuImpl implements BukuService {

    private static final String BASE_URL = "https://s3.lynk2.co/api/s3";
    private final BukuRepository bukuRepository;
    private final AdminRepository adminRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public BukuImpl(BukuRepository bukuRepository, AdminRepository adminRepository) {
        this.bukuRepository = bukuRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    @Override
    public List<Buku> getAllByAdmin(Long idAdmin) {
        return bukuRepository.findByAdminId(idAdmin);
    }

    @Override
    public Optional<Buku> getBukuById(Long id) {
        return bukuRepository.findById(id);
    }

    @Override
    public BukuDTO tambahBukuDTO(Long idAdmin, BukuDTO bukuDTO) {
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin not found"));

        Buku buku = convertToEntity(bukuDTO);
        buku.setAdmin(admin);

        Buku savedBuku = bukuRepository.save(buku);
        return convertToDTO(savedBuku);
    }

    @Override
    public BukuDTO editBukuDTO(Long id, Long idAdmin, String bukuJson, MultipartFile file) throws IOException {
        Buku existingBuku = bukuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Buku tidak ditemukan"));

        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin tidak ditemukan"));

        ObjectMapper objectMapper = new ObjectMapper();
        BukuDTO bukuDTO = objectMapper.readValue(bukuJson, BukuDTO.class);

        existingBuku.setAdmin(admin);
        existingBuku.setJudulBuku(bukuDTO.getJudulBuku());
        existingBuku.setIsbn(bukuDTO.getIsbn());
        existingBuku.setPenerbit(bukuDTO.getPenerbit());
        existingBuku.setPengarang(bukuDTO.getPengarang());
        existingBuku.setTahunTerbit(bukuDTO.getTahunTerbit());
        existingBuku.setJumlahHalaman(bukuDTO.getJumlahHalaman());

        if (file != null) {
            String fotoUrl = uploadFoto(file);
            existingBuku.setFotoUrl(fotoUrl);
        }

        Buku updatedBuku = bukuRepository.save(existingBuku);
        return convertToDTO(updatedBuku);
    }

    @Override
    public void deleteBuku(Long id) {
        bukuRepository.deleteById(id);
    }

    private String uploadFoto(MultipartFile file) throws IOException {
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
    public Buku convertToEntity(BukuDTO bukuDTO) {
        Buku buku = new Buku();
        buku.setJudulBuku(bukuDTO.getJudulBuku());
        buku.setIsbn(bukuDTO.getIsbn());
        buku.setPenerbit(bukuDTO.getPenerbit());
        buku.setPengarang(bukuDTO.getPengarang());
        buku.setTahunTerbit(bukuDTO.getTahunTerbit());
        buku.setJumlahHalaman(bukuDTO.getJumlahHalaman());
        buku.setFotoUrl(bukuDTO.getFotoUrl());
        return buku;
    }

    @Override
    public BukuDTO convertToDTO(Buku buku) {
        BukuDTO bukuDTO = new BukuDTO();
        bukuDTO.setId(buku.getId());
        bukuDTO.setJudulBuku(buku.getJudulBuku());
        bukuDTO.setIsbn(buku.getIsbn());
        bukuDTO.setPenerbit(buku.getPenerbit());
        bukuDTO.setPengarang(buku.getPengarang());
        bukuDTO.setTahunTerbit(buku.getTahunTerbit());
        bukuDTO.setJumlahHalaman(buku.getJumlahHalaman());
        bukuDTO.setFotoUrl(buku.getFotoUrl());
        return bukuDTO;
    }
}
