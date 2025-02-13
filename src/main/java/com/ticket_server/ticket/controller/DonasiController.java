package com.ticket_server.ticket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DonasiController {

    private final DonasiService donasiService;
    private final ObjectMapper objectMapper;

    public DonasiController(DonasiService donasiService, ObjectMapper objectMapper) {
        this.donasiService = donasiService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/donasi/all")
    public ResponseEntity<List<Donasi>> getAllDonasi() {
        List<Donasi> donasiList = donasiService.getAllDonasi();
        if (donasiList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donasiList);
    }

    @GetMapping("/donasi/getById/{id}")
    public ResponseEntity<DonasiDTO> getDonasiById(@PathVariable Long id) {
        Optional<Donasi> donasi = donasiService.getDonasiById(id);
        return donasi.map(donasiEntity -> ResponseEntity.ok(new DonasiDTO(donasiEntity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/donasi/tambah")
    public ResponseEntity<DonasiDTO> tambahDonasi(
            @RequestParam("donasi") String donasiJson,
            @RequestParam(value = "foto", required = false) MultipartFile foto) throws IOException {

        DonasiDTO donasiDTO = objectMapper.readValue(donasiJson, DonasiDTO.class);

        if (foto != null) {
            String fotoUrl = donasiService.uploadFoto(foto);
            donasiDTO.setFotoUrl(fotoUrl);
        }

        DonasiDTO savedDonasi = donasiService.tambahDonasi(donasiDTO);
        return ResponseEntity.ok(savedDonasi);
    }

    @PutMapping("/donasi/editById/{id}")
    public ResponseEntity<DonasiDTO> editDonasi(
            @PathVariable Long id,
            @RequestParam("donasi") Long donasiJson,
            @RequestParam(value = "foto", required = false) MultipartFile foto) throws IOException {

        DonasiDTO updatedDonasi = donasiService.editDonasi(id, donasiJson, (DonasiDTO) foto);
        return ResponseEntity.ok(updatedDonasi);
    }

    @DeleteMapping("/donasi/delete/{id}")
    public ResponseEntity<Void> deleteDonasi(@PathVariable Long id) throws IOException {
        donasiService.deleteDonasi(id);
        return ResponseEntity.noContent().build();
    }
}