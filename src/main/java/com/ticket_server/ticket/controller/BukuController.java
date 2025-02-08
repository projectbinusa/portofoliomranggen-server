package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.service.BukuService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping("/buku/all")
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> bukuList = bukuService.getAllBuku();
        return ResponseEntity.ok(bukuList);
    }

    @GetMapping("/buku/getById/{id}")
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
            return ResponseEntity.ok(bukuDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/buku/tambah")
    public ResponseEntity<BukuDTO> tambahBuku(@RequestBody BukuDTO bukuDTO) {
        BukuDTO savedBuku = bukuService.tambahBukuDTO(bukuDTO);
        return ResponseEntity.ok(savedBuku);
    }

    @PutMapping(value = "/buku/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BukuDTO> editBuku(
            @PathVariable Long id,
            @RequestBody BukuDTO bukuDTO) throws IOException {

        BukuDTO updatedBuku = bukuService.editBukuDTO(id, bukuDTO);
        return ResponseEntity.ok(updatedBuku);
    }

    @DeleteMapping("/buku/delete/{id}")
    public ResponseEntity<Void> deleteBuku(@PathVariable Long id) throws IOException {
        bukuService.deleteBuku(id);
        return ResponseEntity.noContent().build();
    }
}
