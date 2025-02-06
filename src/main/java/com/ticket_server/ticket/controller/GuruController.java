package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.service.GuruService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/guru")
public class GuruController {

    private static final Logger logger = LoggerFactory.getLogger(GuruController.class);
    private final GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GuruDTO>> getAllGuru() {
        return ResponseEntity.ok(guruService.getAllGuru());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GuruDTO> getGuruById(@PathVariable Long id) {
        return ResponseEntity.ok(guruService.getGuruById(id));
    }

    @PostMapping("/tambah")
    public ResponseEntity<GuruDTO> tambahGuru(@Valid @RequestBody GuruDTO guruDTO) {
        logger.info("Menambahkan guru dengan idAdmin: {}", guruDTO.getIdAdmin());
        GuruDTO savedGuru = guruService.tambahGuruDTO(guruDTO);
        return new ResponseEntity<>(savedGuru, HttpStatus.CREATED);
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<GuruDTO> editGuru(
            @PathVariable Long id,
            @Valid @RequestBody GuruDTO guruDTO) throws IOException {
        logger.info("Mengedit guru ID: {}, idAdmin: {}", id, guruDTO.getIdAdmin());
        GuruDTO updatedGuru = guruService.editGuruDTO(id, guruDTO);
        return ResponseEntity.ok(updatedGuru);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuru(@PathVariable Long id) throws IOException {
        guruService.deleteGuru(id);
        return ResponseEntity.noContent().build();
    }
}
