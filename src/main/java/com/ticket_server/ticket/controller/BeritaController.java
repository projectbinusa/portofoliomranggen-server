package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BeritaController {

    private final BeritaService beritaService;

    public BeritaController(BeritaService beritaService) {
        this.beritaService = beritaService;
    }

    @GetMapping("/berita/all")
    public ResponseEntity<List<Berita>> getAllBerita() {
        List<Berita> beritaList = beritaService.getAllBerita();
        return ResponseEntity.ok(beritaList);
    }

    @GetMapping("/berita/getById/{id}")
    public ResponseEntity<BeritaDTO> getBeritaById(@PathVariable Long id) {
        Optional<Berita> berita = beritaService.getBeritaById(id);
        return berita.map(beritaEntity -> {
            BeritaDTO beritaDTO = new BeritaDTO();
            beritaDTO.setId(beritaEntity.getId());
            beritaDTO.setNama(beritaEntity.getNama());
            beritaDTO.setPenulis(beritaEntity.getPenulis());
            beritaDTO.setDeskripsi(beritaEntity.getDeskripsi());
            beritaDTO.setFotoUrl(beritaEntity.getFotoUrl());
            beritaDTO.setTanggalTerbit(beritaEntity.getTanggalTerbit());
            beritaDTO.setAction(beritaEntity.getAction());
            return ResponseEntity.ok(beritaDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/berita/tambah")
    public ResponseEntity<BeritaDTO> tambahBerita(@RequestBody BeritaDTO beritaDTO) {
        BeritaDTO savedBerita = beritaService.tambahBeritaDTO(beritaDTO);
        return ResponseEntity.ok(savedBerita);
    }

    @PutMapping(value = "/berita/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeritaDTO> editBerita(
            @PathVariable Long id,
            @RequestBody BeritaDTO beritaDTO) throws IOException {

        BeritaDTO updatedBerita = beritaService.editBeritaDTO(id, beritaDTO);
        return ResponseEntity.ok(updatedBerita);
    }

    @DeleteMapping("/berita/delete/{id}")
    public ResponseEntity<Void> deleteBerita(@PathVariable Long id) throws IOException {
        beritaService.deleteBerita(id);
        return ResponseEntity.noContent().build();
    }
}
