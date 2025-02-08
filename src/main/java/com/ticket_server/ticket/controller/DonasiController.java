package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DonasiController {

    private final DonasiService donasiService;

    public DonasiController(DonasiService donasiService) {
        this.donasiService = donasiService;
    }

    @GetMapping("/donasi/all")
    public ResponseEntity<List<Donasi>> getAllDonasi() {
        List<Donasi> donasiList = donasiService.getAllDonasi();
        return ResponseEntity.ok(donasiList);
    }

    @GetMapping("/donasi/getById/{id}")
    public ResponseEntity<DonasiDTO> getDonasiById(@PathVariable Long id) {
        Optional<Donasi> donasi = donasiService.getDonasiById(id);
        return donasi.map(donasiEntity -> {
            DonasiDTO donasiDTO = new DonasiDTO(donasiEntity);
            return ResponseEntity.ok(donasiDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/donasi/tambah")
    public ResponseEntity<DonasiDTO> tambahDonasi(@RequestBody DonasiDTO donasiDTO) {
        DonasiDTO savedDonasi = donasiService.tambahDonasi(donasiDTO);
        return ResponseEntity.ok(savedDonasi);
    }

    @PutMapping(value = "/donasi/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DonasiDTO> editDonasi(@PathVariable Long id, @RequestBody DonasiDTO donasiDTO) throws IOException {
        DonasiDTO updatedDonasi = donasiService.editDonasi(id, donasiDTO);
        return ResponseEntity.ok(updatedDonasi);
    }

    @DeleteMapping("/donasi/delete/{id}")
    public ResponseEntity<Void> deleteDonasi(@PathVariable Long id) throws IOException {
        donasiService.deleteDonasi(id);
        return ResponseEntity.noContent().build();
    }
}
