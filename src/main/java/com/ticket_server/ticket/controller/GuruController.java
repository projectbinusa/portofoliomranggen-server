package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.service.GuruService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<GuruDTO> guruList = guruService.getAllGuru();
        if (guruList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(guruList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GuruDTO> getGuruById(@PathVariable Long id) {
        GuruDTO guruDTO = guruService.getGuruById(id);
        return guruDTO != null ? ResponseEntity.ok(guruDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping("/tambah")
    public ResponseEntity<GuruDTO> tambahGuru(@Valid @RequestBody GuruDTO guruDTO) {
        logger.info("Request tambah guru diterima: {}", guruDTO);

        GuruDTO savedGuru = guruService.tambahGuruDTO(guruDTO);
        return new ResponseEntity<>(savedGuru, HttpStatus.CREATED);
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<GuruDTO> editGuru(
            @PathVariable Long id,
            @Valid @RequestBody GuruDTO guruDTO) {
        logger.info("Mengedit guru ID: {}, idAdmin: {}", id, guruDTO.getIdAdmin());
        GuruDTO updatedGuru = guruService.editGuruDTO(id, guruDTO);
        return updatedGuru != null ? ResponseEntity.ok(updatedGuru) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuru(@PathVariable Long id) {
        boolean isDeleted = guruService.deleteGuru(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
