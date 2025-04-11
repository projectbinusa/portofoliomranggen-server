package com.ticket_server.ticket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.service.BukuService;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> bukuList = bukuService.getAllBuku();
        return ResponseEntity.ok(bukuList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<BukuDTO> getBukuById(@PathVariable Long id) {
        Optional<Buku> buku = bukuService.getBukuById(id);
        return buku.map(bukuEntity -> {
            BukuDTO bukuDTO = new BukuDTO();
            bukuDTO.setId(bukuEntity.getId());
            bukuDTO.setJudulBuku(bukuEntity.getJudulBuku());
            bukuDTO.setPenerbit(bukuEntity.getPenerbit());
            bukuDTO.setPengarang(bukuEntity.getPengarang());
            bukuDTO.setTahunTerbit(bukuEntity.getTahunTerbit());
            bukuDTO.setJumlahHalaman(bukuEntity.getJumlahHalaman());
            bukuDTO.setFotoUrl(bukuEntity.getFotoUrl());
            bukuDTO.setIdAdmin(bukuEntity.getIdAdmin());
            return ResponseEntity.ok(bukuDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<?> tambahBuku(@RequestBody BukuDTO bukuDTO) {
        try {
            BukuDTO savedBuku = bukuService.tambahBukuDTO(bukuDTO);
            return ResponseEntity.ok(savedBuku);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal tambah buku: " + e.getMessage());
        }
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<?> updateBuku(
            @PathVariable Long id,
            @RequestBody BukuDTO bukuDTO) {
        try {
            BukuDTO updatedBuku = bukuService.editBukuDTO(id, bukuDTO);
            return ResponseEntity.ok(updatedBuku);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal update buku: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBuku(@PathVariable Long id) throws IOException {
        bukuService.deleteBuku(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/uploadFoto")
    public ResponseEntity<String> uploadFoto(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileUrl = uploadFotoToServer(multipartFile);
        return ResponseEntity.ok(fileUrl);
    }

    private String uploadFotoToServer(MultipartFile multipartFile) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String base_url = "https://s3.lynk2.co/api/s3/absenMasuk";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", multipartFile.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(base_url, HttpMethod.POST, requestEntity, String.class);

        return extractFileUrlFromResponse(response.getBody());
    }

    private String extractFileUrlFromResponse(String responseBody) {
        JSONObject json = new JSONObject(responseBody);
        return json.getJSONObject("data").getString("url_file");
    }
}
