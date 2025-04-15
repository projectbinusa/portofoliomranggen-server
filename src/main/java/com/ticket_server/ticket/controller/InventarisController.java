package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.model.Inventaris;
import com.ticket_server.ticket.service.InventarisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/inventaris")
public class InventarisController {

    private final InventarisService inventarisService;

    public InventarisController(InventarisService inventarisService) {
        this.inventarisService = inventarisService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventaris>> getAllInventaris() {
        List<Inventaris> inventarisList = inventarisService.getAllInventaris();
        if (inventarisList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inventarisList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventaris> getInventarisById(@PathVariable Long id) {
        Optional<Inventaris> inventaris = inventarisService.getInventarisById(id);
        return inventaris.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<Inventaris> tambahInventaris(@RequestBody Inventaris inventaris, @RequestParam Long adminId) {
        try {
            Inventaris savedInventaris = inventarisService.tambahInventaris(inventaris, adminId);
            return ResponseEntity.ok(savedInventaris);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Inventaris> editInventaris(@PathVariable Long id, @RequestBody Inventaris inventaris, @RequestParam Long adminId) {
        Inventaris updatedInventaris = inventarisService.editInventaris(id, inventaris, adminId);
        return ResponseEntity.ok(updatedInventaris);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventaris(@PathVariable Long id) {
        boolean deleted = inventarisService.deleteInventaris(id);
        if (deleted) {
            return ResponseEntity.ok("Inventaris dengan ID " + id + " berhasil dihapus.");
        } else {
            return ResponseEntity.status(404).body("Inventaris dengan ID " + id + " tidak ditemukan.");
        }
    }

}
