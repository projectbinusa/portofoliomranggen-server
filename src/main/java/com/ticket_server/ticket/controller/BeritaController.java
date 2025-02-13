package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/berita")
public class BeritaController {

    private final BeritaService beritaService;

    public BeritaController(BeritaService beritaService) {
        this.beritaService = beritaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Berita>> getAllBerita() {
        return ResponseEntity.ok(beritaService.getAllBerita());
    }

    @GetMapping("/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<Berita>> getAllByAdmin(@PathVariable Long idAdmin) {
        return ResponseEntity.ok(beritaService.getAllByAdmin(idAdmin));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<BeritaDTO> getBeritaById(@PathVariable Long id) {
        Optional<BeritaDTO> berita = beritaService.getBeritaById(id);
        return berita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah/{idAdmin}")
    public ResponseEntity<BeritaDTO> tambahBerita(@PathVariable Long idAdmin, @RequestBody BeritaDTO beritaDTO) {
        return ResponseEntity.ok(beritaService.tambahBeritaDTO(beritaDTO, idAdmin));
    }

    @PutMapping("/edit/{id}/{idAdmin}")
    public ResponseEntity<BeritaDTO> editBerita(@PathVariable Long id, @PathVariable Long idAdmin, @RequestBody BeritaDTO beritaDTO) {
        return ResponseEntity.ok(beritaService.editBeritaDTO(id, beritaDTO, idAdmin));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBerita(@PathVariable Long id) {
        beritaService.deleteBerita(id);
        return ResponseEntity.noContent().build();
    }
}
