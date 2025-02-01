package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.model.Guru;
import com.ticket_server.ticket.service.GuruService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<List<Guru>> getAllGuru() {
        return ResponseEntity.ok(guruService.getAllGuru());
    }

    @GetMapping("/guru/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<Guru>> getAllByAdmin(@PathVariable Long idAdmin) {
        return ResponseEntity.ok(guruService.getAllByAdmin(idAdmin));
    }

    @GetMapping("/guru/getById/{id}")
    public ResponseEntity<Guru> getGuruById(@PathVariable Long id) {
        return guruService.getGuruById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guru/tambah/{idAdmin}")
    public ResponseEntity<GuruDTO> tambahGuru(@PathVariable Long idAdmin, @RequestBody GuruDTO guruDTO) {
        return ResponseEntity.ok(guruService.tambahGuruDTO(idAdmin, guruDTO));
    }

    @PutMapping("/guru/edit/{id}/{idAdmin}")
    public ResponseEntity<GuruDTO> editGuru(
            @PathVariable Long id,
            @PathVariable Long idAdmin,
            @RequestParam("guru") String guruJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(guruService.editGuruDTO(id, idAdmin, guruJson, file));
    }

    @DeleteMapping("/guru/delete/{id}")
    public ResponseEntity<Void> deleteGuru(@PathVariable Long id) throws IOException {
        guruService.deleteGuru(id);
        return ResponseEntity.noContent().build();
    }
}
