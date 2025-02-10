package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.KategoriDTO;
import com.ticket_server.ticket.model.Kategori;
import com.ticket_server.ticket.service.KategoriService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/kategori")
public class KategoriController {

    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<KategoriDTO>> getAllKategori() {
        List<KategoriDTO> kategoriList = kategoriService.getAllKategori();
        if (kategoriList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(kategoriList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KategoriDTO> getKategoriById(@PathVariable Long id) {
        Optional<KategoriDTO> kategori = kategoriService.getKategoriById(id);
        return kategori.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<KategoriDTO> tambahKategori(@RequestBody Kategori kategori) {
        try {
            KategoriDTO savedKategori = kategoriService.tambahKategori(kategori);
            return ResponseEntity.ok(savedKategori);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<KategoriDTO> editKategori(@PathVariable Long id, @RequestBody Kategori kategori) {
        KategoriDTO updatedKategori = kategoriService.editKategori(id, kategori);
        return ResponseEntity.ok(updatedKategori);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKategori(@PathVariable Long id) {
        kategoriService.deleteKategori(id);
        return ResponseEntity.noContent().build();
    }
}
