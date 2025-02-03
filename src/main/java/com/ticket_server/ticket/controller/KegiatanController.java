package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.KegiatanDTO;
import com.ticket_server.ticket.model.Kegiatan;
import com.ticket_server.ticket.service.KegiatanService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class KegiatanController {

    private final KegiatanService kegiatanService;

    public KegiatanController(KegiatanService kegiatanService) {
        this.kegiatanService = kegiatanService;
    }

    @GetMapping("/kegiatan/all")
    public ResponseEntity<List<Kegiatan>> getAllKegiatan() {
        List<Kegiatan> kegiatanList = kegiatanService.getAllKegiatan();
        return ResponseEntity.ok(kegiatanList);
    }

    @GetMapping("/kegiatan/getById/{id}")
    public ResponseEntity<KegiatanDTO> getKegiatanById(@PathVariable Long id) {
        Optional<Kegiatan> kegiatan = kegiatanService.getKegiatanById(id);
        return kegiatan.map(kegiatanEntity -> {
            KegiatanDTO kegiatanDTO = new KegiatanDTO();
            kegiatanDTO.setId(kegiatanEntity.getId());
            kegiatanDTO.setNamaKegiatan(kegiatanEntity.getNamaKegiatan());
            kegiatanDTO.setDeskripsi(kegiatanEntity.getDeskripsi());
            kegiatanDTO.setPenanggungJawab(kegiatanEntity.getPenanggungJawab());
            kegiatanDTO.setCreateDate(kegiatanEntity.getCreateDate());
            return ResponseEntity.ok(kegiatanDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/kegiatan/tambah")
    public ResponseEntity<KegiatanDTO> tambahKegiatan(@RequestBody KegiatanDTO kegiatanDTO) {
        KegiatanDTO savedKegiatan = kegiatanService.tambahKegiatanDTO(kegiatanDTO);
        return ResponseEntity.ok(savedKegiatan);
    }

    @PutMapping(value = "/kegiatan/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KegiatanDTO> editKegiatan(
            @PathVariable Long id,
            @RequestBody KegiatanDTO kegiatanDTO) throws IOException {

        KegiatanDTO updatedKegiatan = kegiatanService.editKegiatanDTO(id, kegiatanDTO);
        return ResponseEntity.ok(updatedKegiatan);
    }

    @DeleteMapping("/kegiatan/delete/{id}")
    public ResponseEntity<Void> deleteKegiatan(@PathVariable Long id) throws IOException {
        kegiatanService.deleteKegiatan(id);
        return ResponseEntity.noContent().build();
    }
}
