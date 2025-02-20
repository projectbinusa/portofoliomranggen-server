package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.http.HttpStatus;
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

    // 🔹 GET: Ambil semua berita
    @GetMapping("/all")
    public ResponseEntity<List<Berita>> getAllBerita() {
        List<Berita> beritaList = beritaService.getAllBerita();
        return ResponseEntity.ok(beritaList);
    }

    // 🔹 GET: Ambil berita berdasarkan ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<BeritaDTO> getBeritaById(@PathVariable Long id) {
        Optional<Berita> berita = beritaService.getBeritaById(id);
        return berita.map(beritaEntity -> {
            BeritaDTO beritaDTO = new BeritaDTO();
            beritaDTO.setId(beritaEntity.getId());
            beritaDTO.setNama(beritaEntity.getNama());
            beritaDTO.setPenulis(beritaEntity.getPenulis());
            beritaDTO.setDeskripsi(beritaEntity.getDeskripsi());
            beritaDTO.setTanggalTerbit(beritaEntity.getTanggalTerbit());
            beritaDTO.setFotoUrl(beritaEntity.getFotoUrl());
            beritaDTO.setIdAdmin(beritaEntity.getIdAdmin()); // ID Admin Ditambahkan
            return ResponseEntity.ok(beritaDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 POST: Tambah Berita Baru
    @PostMapping("/tambah")
    public ResponseEntity<BeritaDTO> tambahBerita(@RequestBody BeritaDTO beritaDTO) {
        BeritaDTO savedBerita = beritaService.tambahBeritaDTO(beritaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBerita);
    }

    // 🔹 PUT: Update Berita Berdasarkan ID
    @PutMapping("/editById/{id}")
    public ResponseEntity<?> updateBerita(@PathVariable Long id, @RequestBody BeritaDTO beritaDTO) {
        try {
            BeritaDTO updatedBerita = beritaService.editBeritaDTO(id, beritaDTO);
            return ResponseEntity.ok(updatedBerita);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal memperbarui berita: " + e.getMessage());
        }
    }

    // 🔹 DELETE: Hapus Berita Berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBerita(@PathVariable Long id) {
        try {
            beritaService.deleteBerita(id);
            return ResponseEntity.ok("Berita berhasil dihapus");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal menghapus berita: " + e.getMessage());
        }
    }
}