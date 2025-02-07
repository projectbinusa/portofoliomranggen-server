package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.service.GuruService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class GuruController {

    private final GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }

    @GetMapping("/guru/all")
    public ResponseEntity<List<GuruDTO>> getAllGuru() {
        List<GuruDTO> guruDTOList = guruService.getAllGuru();
        return ResponseEntity.ok(guruDTOList);
    }

    @GetMapping("/guru/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<GuruDTO>> getAllByAdmin(@PathVariable Long idAdmin) {
        List<GuruDTO> guruDTOList = guruService.getAllByAdmin(idAdmin);
        return ResponseEntity.ok(guruDTOList);
    }

    @GetMapping("/guru/getById/{id}")
    public ResponseEntity<GuruDTO> getGuruById(@PathVariable Long id) {
        GuruDTO guruDTO = guruService.getGuruById(id);
        return ResponseEntity.ok(guruDTO);
    }

    @PostMapping("/guru/tambah/{idAdmin}")
    public ResponseEntity<GuruDTO> tambahGuru(@PathVariable Long idAdmin, @RequestBody GuruDTO guruDTO) {
        GuruDTO newGuru = guruService.tambahGuruDTO(idAdmin, guruDTO);
        return ResponseEntity.ok(newGuru);
    }

    @PutMapping("/guru/edit/{id}/{idAdmin}")
    public ResponseEntity<GuruDTO> editGuru(@PathVariable Long id, @PathVariable Long idAdmin, @RequestBody GuruDTO guruDTO) {
        GuruDTO updatedGuru = guruService.editGuruDTO(id, idAdmin, guruDTO);
        return ResponseEntity.ok(updatedGuru);
    }

    @DeleteMapping("/guru/delete/{id}")
    public ResponseEntity<Void> deleteGuru(@PathVariable Long id) {
        guruService.deleteGuru(id);
        return ResponseEntity.noContent().build();
    }
}