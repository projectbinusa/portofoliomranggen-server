package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.service.BukuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping("/buku/all")
    public ResponseEntity<List<Buku>> getAllBuku() {
        return ResponseEntity.ok(bukuService.getAllBuku());
    }

    @GetMapping("/buku/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<Buku>> getAllByAdmin(@PathVariable Long idAdmin) {
        return ResponseEntity.ok(bukuService.getAllByAdmin(idAdmin));
    }

    @GetMapping("/buku/getById/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable Long id) {
        return bukuService.getBukuById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/buku/tambah/{idAdmin}")
    public ResponseEntity<BukuDTO> tambahBuku(
            @PathVariable Long idAdmin,
            @RequestBody BukuDTO bukuDTO) {
        return ResponseEntity.ok(bukuService.tambahBukuDTO(idAdmin, bukuDTO));
    }

    @PutMapping("/buku/edit/{id}/{idAdmin}")
    public ResponseEntity<BukuDTO> editBuku(
            @PathVariable Long id,
            @PathVariable Long idAdmin,
            @RequestParam("buku") String bukuJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(bukuService.editBukuDTO(id, idAdmin, bukuJson, file));
    }

    @DeleteMapping("/buku/delete/{id}")
    public ResponseEntity<Void> deleteBuku(@PathVariable Long id) throws IOException {
        bukuService.deleteBuku(id);
        return ResponseEntity.noContent().build();
    }
}