package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.SiswaDTO;
import com.ticket_server.ticket.model.Siswa;
import com.ticket_server.ticket.service.SiswaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SiswaController {

    private final SiswaService siswaService;

    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping("/siswa/all")
    public ResponseEntity<List<Siswa>> getAllSiswa() {
        List<Siswa> siswaList = siswaService.getAllSiswa();
        return ResponseEntity.ok(siswaList);
    }

    @GetMapping("/siswa/getById/{id}")
    public ResponseEntity<SiswaDTO> getSiswaById(@PathVariable Long id) {
        Optional<Siswa> siswa = siswaService.getSiswaById(id);
        return siswa.map(siswaEntity -> {
            SiswaDTO siswaDTO = new SiswaDTO();
            siswaDTO.setId(siswaEntity.getId());
            siswaDTO.setNama(siswaEntity.getNama());
            siswaDTO.setNisn(siswaEntity.getNisn());
            siswaDTO.setAlamat(siswaEntity.getAlamat());
            siswaDTO.setNamaOrangtua(siswaEntity.getNamaOrangtua());
            siswaDTO.setNomerHpOrangtua(siswaEntity.getNomerHpOrangtua());
            siswaDTO.setNomerHp(siswaEntity.getNomerHp());
            siswaDTO.setTanggalLahir(siswaEntity.getTanggalLahir());
            return ResponseEntity.ok(siswaDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/siswa/tambah")
    public ResponseEntity<SiswaDTO> tambahSiswa(@RequestBody SiswaDTO siswaDTO) {
        SiswaDTO savedSiswa = siswaService.tambahSiswaDTO(siswaDTO);
        return ResponseEntity.ok(savedSiswa);
    }

    @PutMapping(value = "/siswa/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SiswaDTO> editSiswa(
            @PathVariable Long id,
            @RequestBody SiswaDTO siswaDTO) throws IOException {

        SiswaDTO updatedSiswa = siswaService.editSiswaDTO(id, siswaDTO);
        return ResponseEntity.ok(updatedSiswa);
    }

    @DeleteMapping("/siswa/delete/{id}")
    public ResponseEntity<Void> deleteSiswa(@PathVariable Long id) throws IOException {
        siswaService.deleteSiswa(id);
        return ResponseEntity.noContent().build();
    }
}