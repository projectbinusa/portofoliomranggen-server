package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.PesananDTO;
import com.ticket_server.ticket.model.Pesanan;
import com.ticket_server.ticket.service.PesananService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pesanan")
public class PesananController {

    private final PesananService pesananService;

    public PesananController(PesananService pesananService) {
        this.pesananService = pesananService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pesanan>> getAllPesanan() {
        return ResponseEntity.ok(pesananService.getAllPesanan());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PesananDTO> getPesananById(@PathVariable Long id) {
        Optional<Pesanan> pesanan = pesananService.getPesananById(id);
        return pesanan.map(pes -> {
            PesananDTO dto = new PesananDTO(pes);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<PesananDTO> tambahPesanan(@RequestBody PesananDTO pesananDTO) {
        return ResponseEntity.ok(pesananService.tambahPesanan(pesananDTO));
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<PesananDTO> editPesanan(@PathVariable Long id, @RequestBody PesananDTO pesananDTO) {
        return ResponseEntity.ok(pesananService.editPesanan(id, pesananDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePesanan(@PathVariable Long id) {
        pesananService.deletePesanan(id);
        return ResponseEntity.noContent().build();
    }
}
