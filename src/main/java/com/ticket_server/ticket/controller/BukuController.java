package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.service.BukuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    // 🔹 GET: Ambil semua buku
    @GetMapping("/all")
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> bukuList = bukuService.getAllBuku();
        return ResponseEntity.ok(bukuList);
    }

    // 🔹 GET: Ambil buku berdasarkan ID
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
            bukuDTO.setIdAdmin(bukuEntity.getIdAdmin()); // ID Admin Ditambahkan
            return ResponseEntity.ok(bukuDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 POST: Tambah Buku Baru
    @PostMapping("/tambah")
    public ResponseEntity<BukuDTO> tambahBuku(@RequestBody BukuDTO bukuDTO) {
        BukuDTO savedBuku = bukuService.tambahBukuDTO(bukuDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuku);
    }

    // 🔹 PUT: Update Buku Berdasarkan ID
    @PutMapping("/editByid/{id}")
    public ResponseEntity<?> updateBuku(@PathVariable Long id, @RequestBody BukuDTO bukuDTO) {
        try {
            BukuDTO updatedBuku = bukuService.editBukuDTO(id, bukuDTO);
            return ResponseEntity.ok(updatedBuku);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal memperbarui buku: " + e.getMessage());
        }
    }


    // 🔹 DELETE: Hapus Buku Berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBuku(@PathVariable Long id) {
        try {
            bukuService.deleteBuku(id);
            return ResponseEntity.ok("Buku berhasil dihapus");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal menghapus buku: " + e.getMessage());
        }
    }
}
