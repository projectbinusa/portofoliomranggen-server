package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/donasi")
public class DonasiController {

    private final DonasiService donasiService;

    public DonasiController(DonasiService donasiService) {
        this.donasiService = donasiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Donasi>> getAllDonasi() {
        return ResponseEntity.ok(donasiService.getAllDonasi());
    }

    @GetMapping("/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<Donasi>> getAllByAdmin(@PathVariable Long idAdmin) {
        return ResponseEntity.ok(donasiService.getAllByAdmin(idAdmin));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DonasiDTO> getDonasiById(@PathVariable Long id) {
        Optional<DonasiDTO> donasi = donasiService.getDonasiById(id);
        return donasi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah/{idAdmin}")
    public ResponseEntity<DonasiDTO> tambahDonasi(@PathVariable Long idAdmin, @RequestBody DonasiDTO donasiDTO) {
        return ResponseEntity.ok(donasiService.tambahDonasiDTO(donasiDTO, idAdmin));
    }

    @PutMapping("/edit/{id}/{idAdmin}")
    public ResponseEntity<DonasiDTO> editDonasi(@PathVariable Long id, @PathVariable Long idAdmin, @RequestBody DonasiDTO donasiDTO) throws IOException {
        return ResponseEntity.ok(donasiService.editDonasiDTO(id, donasiDTO, idAdmin));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDonasi(@PathVariable Long id) {
        donasiService.deleteDonasi(id);
        return ResponseEntity.noContent().build();
    }
}