package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.repository.BukuRepository;
import com.ticket_server.ticket.service.BukuService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final RestTemplate restTemplate = new RestTemplate();

    public BukuImpl(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Override
    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    @Override
    public Optional<Buku> getBukuById(Long id) {
        return bukuRepository.findById(id);
    }

    @Override
    public BukuDTO tambahBukuDTO(BukuDTO bukuDTO) {
        Buku buku = new Buku();
        buku.setJudulBuku(bukuDTO.getJudulBuku());
        buku.setPenerbit(bukuDTO.getPenerbit());
        buku.setPengarang(bukuDTO.getPengarang());
        buku.setTahunTerbit(bukuDTO.getTahunTerbit());
        buku.setJumlahHalaman(bukuDTO.getJumlahHalaman());
        buku.setFotoUrl(bukuDTO.getFotoUrl());
        buku.setIdAdmin(bukuDTO.getIdAdmin());

        Buku savedBuku = bukuRepository.save(buku);

        BukuDTO result = new BukuDTO();
        result.setId(savedBuku.getId());
        result.setJudulBuku(savedBuku.getJudulBuku());
        result.setPenerbit(savedBuku.getPenerbit());
        result.setPengarang(savedBuku.getPengarang());
        result.setTahunTerbit(savedBuku.getTahunTerbit());
        result.setJumlahHalaman(savedBuku.getJumlahHalaman());
        result.setFotoUrl(savedBuku.getFotoUrl());
        result.setIdAdmin(savedBuku.getIdAdmin());

        return result;
    }

    @Override
    public BukuDTO editBukuDTO(Long id, BukuDTO bukuDTO) {
        Buku existingBuku = bukuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Buku tidak ditemukan"));

        existingBuku.setJudulBuku(bukuDTO.getJudulBuku());
        existingBuku.setPenerbit(bukuDTO.getPenerbit());
        existingBuku.setPengarang(bukuDTO.getPengarang());
        existingBuku.setTahunTerbit(bukuDTO.getTahunTerbit());
        existingBuku.setJumlahHalaman(bukuDTO.getJumlahHalaman());
        existingBuku.setFotoUrl(bukuDTO.getFotoUrl());
        existingBuku.setIdAdmin(bukuDTO.getIdAdmin());

        Buku updatedBuku = bukuRepository.save(existingBuku);

        BukuDTO result = new BukuDTO();
        result.setId(updatedBuku.getId());
        result.setJudulBuku(updatedBuku.getJudulBuku());
        result.setPenerbit(updatedBuku.getPenerbit());
        result.setPengarang(updatedBuku.getPengarang());
        result.setTahunTerbit(updatedBuku.getTahunTerbit());
        result.setJumlahHalaman(updatedBuku.getJumlahHalaman());
        result.setFotoUrl(updatedBuku.getFotoUrl());
        result.setIdAdmin(updatedBuku.getIdAdmin());

        return result;
    }


    @Override
    public void deleteBuku(Long id) {
        if (!bukuRepository.existsById(id)) {
            throw new NotFoundException("Buku tidak ditemukan");
        }
        bukuRepository.deleteById(id);
    }

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
}
