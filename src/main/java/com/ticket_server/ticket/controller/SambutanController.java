package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.SambutanDTO;
import com.ticket_server.ticket.model.Sambutan;
import com.ticket_server.ticket.service.SambutanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SambutanController {

    private final SambutanService sambutanService;

    public SambutanController(SambutanService sambutanService) {
        this.sambutanService = sambutanService;
    }

    @GetMapping("/sambutan/all")
    public ResponseEntity<List<Sambutan>> getAllSambutan() {
        List<Sambutan> sambutanList = sambutanService.getAllSambutan();
        return ResponseEntity.ok(sambutanList);
    }

    @GetMapping("/sambutan/getById/{id}")
    public ResponseEntity<SambutanDTO> getSambutanById(@PathVariable Long id) {
        Optional<Sambutan> sambutan = sambutanService.getSambutanById(id);
        return sambutan.map(sambutanEntity -> {
            SambutanDTO sambutanDTO = new SambutanDTO();
            sambutanDTO.setId(sambutanEntity.getId());
            sambutanDTO.setJudul(sambutanEntity.getJudul());
            sambutanDTO.setDeskripsi(sambutanEntity.getDeskripsi());
            return ResponseEntity.ok(sambutanDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/sambutan/tambah")
    public ResponseEntity<SambutanDTO> tambahSambutan(@RequestBody SambutanDTO sambutanDTO) {
        SambutanDTO savedSambutan = sambutanService.tambahSambutan(sambutanDTO);
        return ResponseEntity.ok(savedSambutan);
    }

    @PutMapping("/sambutan/editById/{id}")
    public ResponseEntity<SambutanDTO> editSambutan(@PathVariable Long id, @RequestBody SambutanDTO sambutanDTO) {
        SambutanDTO updatedSambutan = sambutanService.editSambutan(id, sambutanDTO);
        return ResponseEntity.ok(updatedSambutan);
    }

    @DeleteMapping("/sambutan/delete/{id}")
    public ResponseEntity<Void> deleteSambutan(@PathVariable Long id) {
        sambutanService.deleteSambutan(id);
        return ResponseEntity.noContent().build();
    }
}
