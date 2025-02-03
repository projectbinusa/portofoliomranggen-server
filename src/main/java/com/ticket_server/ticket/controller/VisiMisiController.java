package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.model.VisiMisi;
import com.ticket_server.ticket.service.VisiMisiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/visi-misi")
public class VisiMisiController {

    private final VisiMisiService visiMisiService;

    public VisiMisiController(VisiMisiService visiMisiService) {
        this.visiMisiService = visiMisiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<VisiMisi>> getAllVisiMisi() {
        List<VisiMisi> visiMisiList = visiMisiService.getAllVisiMisi();
        if (visiMisiList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(visiMisiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisiMisi> getVisiMisiById(@PathVariable Long id) {
        Optional<VisiMisi> visiMisi = visiMisiService.getVisiMisiById(id);
        return visiMisi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<VisiMisi> tambahVisiMisi(@RequestBody VisiMisi visiMisi, @RequestParam Long adminId) {
        try {
            VisiMisi savedVisiMisi = visiMisiService.tambahVisiMisi(visiMisi, adminId);
            return ResponseEntity.ok(savedVisiMisi);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<VisiMisi> editVisiMisi(@PathVariable Long id, @RequestBody VisiMisi visiMisi, @RequestParam Long adminId) {
        VisiMisi updatedVisiMisi = visiMisiService.editVisiMisi(id, visiMisi, adminId);
        return ResponseEntity.ok(updatedVisiMisi);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVisiMisi(@PathVariable Long id) {
        visiMisiService.deleteVisiMisi(id);
        return ResponseEntity.noContent().build();
    }
}
