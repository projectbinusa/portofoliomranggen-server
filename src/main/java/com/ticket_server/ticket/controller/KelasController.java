package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.model.Kelas;
import com.ticket_server.ticket.service.KelasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/kelas")
public class KelasController {

    private final KelasService kelasService;

    public KelasController(KelasService kelasService) {
        this.kelasService = kelasService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kelas>> getAllKelas() {
        List<Kelas> kelasList = kelasService.getAllKelas();
        if (kelasList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(kelasList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kelas> getKelasById(@PathVariable Long id) {
        Optional<Kelas> kelas = kelasService.getKelasById(id);
        return kelas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<Kelas> tambahKelas(@RequestBody Kelas kelas) {
        try {
            Kelas savedKelas = kelasService.tambahKelas(kelas);
            return ResponseEntity.ok(savedKelas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Kelas> editKelas(@PathVariable Long id, @RequestBody Kelas kelas) {
        Kelas updatedKelas = kelasService.editKelas(id, kelas);
        return ResponseEntity.ok(updatedKelas);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKelas(@PathVariable Long id) {
        kelasService.deleteKelas(id);
        return ResponseEntity.noContent().build();
    }
}
