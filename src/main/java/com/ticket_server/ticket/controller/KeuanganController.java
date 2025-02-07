package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.KeuanganDTO;
import com.ticket_server.ticket.model.Keuangan;
import com.ticket_server.ticket.service.KeuanganService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class KeuanganController {

    private final KeuanganService keuanganService;

    public KeuanganController(KeuanganService keuanganService) {
        this.keuanganService = keuanganService;
    }

    @GetMapping("/keuangan/all")
    public ResponseEntity<List<Keuangan>> getAllKeuangan() {
        List<Keuangan> keuanganList = keuanganService.getAllKeuangan();
        return ResponseEntity.ok(keuanganList);
    }

    @GetMapping("/keuangan/getById/{id}")
    public ResponseEntity<KeuanganDTO> getKeuanganById(@PathVariable Long id) {
        Optional<Keuangan> keuangan = keuanganService.getKeuanganById(id);
        return keuangan.map(keuanganEntity -> {
            KeuanganDTO keuanganDTO = new KeuanganDTO();
            keuanganDTO.setId(keuanganEntity.getId());
            keuanganDTO.setNama(keuanganEntity.getNama());
            keuanganDTO.setHarga(keuanganEntity.getHarga());
            keuanganDTO.setJumlah(keuanganEntity.getJumlah());
            keuanganDTO.setTotalHarga(keuanganEntity.getTotalHarga());
            keuanganDTO.setKategoriPembiayaan(keuanganEntity.getKategoriPembiayaan());
            keuanganDTO.setCatatan(keuanganEntity.getCatatan());
            return ResponseEntity.ok(keuanganDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/keuangan/tambah")
    public ResponseEntity<KeuanganDTO> tambahKeuangan(@RequestBody KeuanganDTO keuanganDTO) {
        KeuanganDTO savedKeuangan = keuanganService.tambahKeuanganDTO(keuanganDTO);
        return ResponseEntity.ok(savedKeuangan);
    }

    @PutMapping(value = "/keuangan/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KeuanganDTO> editKeuangan(
            @PathVariable Long id,
            @RequestBody KeuanganDTO keuanganDTO) throws IOException {

        KeuanganDTO updatedKeuangan = keuanganService.editKeuanganDTO(id, keuanganDTO);
        return ResponseEntity.ok(updatedKeuangan);
    }

    @DeleteMapping("/keuangan/delete/{id}")
    public ResponseEntity<Void> deleteKeuangan(@PathVariable Long id) throws IOException {
        keuanganService.deleteKeuangan(id);
        return ResponseEntity.noContent().build();
    }
}
