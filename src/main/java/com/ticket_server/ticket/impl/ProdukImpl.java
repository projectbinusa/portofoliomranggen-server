package com.ticket_server.ticket.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import  com.ticket_server.ticket.DTO.ProdukDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Produk;
import com.ticket_server.ticket.repository.ProdukRepository;
import com.ticket_server.ticket.service.ProdukService;
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
public class ProdukImpl implements ProdukService {
    private static final String BASE_URL = "https://s3.lynk2.co/api/s3";
    private final ProdukRepository produkRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public ProdukImpl(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;
    }

    @Override
    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    @Override
    public Optional<Produk> getProdukById(Long id) {
        return produkRepository.findById(id);
    }

    @Override
    public ProdukDTO tambahProdukDTO(ProdukDTO produkDTO) {
        Produk produk = new Produk();
        produk.setNama(produkDTO.getNama());
        produk.setHarga(produkDTO.getHarga());
        produk.setDeskripsi(produkDTO.getDeskripsi());
        produk.setFotoUrl(produkDTO.getFotoUrl());

        Produk savedProduk = produkRepository.save(produk);

        ProdukDTO result = new ProdukDTO();
        result.setId(savedProduk.getId());
        result.setNama(savedProduk.getNama());
        result.setHarga(savedProduk.getHarga());
        result.setDeskripsi(savedProduk.getDeskripsi());
        result.setFotoUrl(savedProduk.getFotoUrl());
        return result;
    }

    @Override
    public ProdukDTO editProdukDTO(Long id, ProdukDTO produkDTO) {
        Produk existingProduk = produkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produk tidak ditemukan"));

        existingProduk.setNama(produkDTO.getNama());
        existingProduk.setHarga(produkDTO.getHarga());
        existingProduk.setDeskripsi(produkDTO.getDeskripsi());
        existingProduk.setFotoUrl(produkDTO.getFotoUrl());

        Produk updatedProduk = produkRepository.save(existingProduk);

        ProdukDTO result = new ProdukDTO();
        result.setId(updatedProduk.getId());
        result.setNama(updatedProduk.getNama());
        result.setHarga(updatedProduk.getHarga());
        result.setDeskripsi(updatedProduk.getDeskripsi());
        result.setFotoUrl(updatedProduk.getFotoUrl());
        return result;
    }

    @Override
    public void deleteProduk(Long id) {
        if (!produkRepository.existsById(id)) {
            throw new NotFoundException("Produk tidak ditemukan");
        }
        produkRepository.deleteById(id);
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
}