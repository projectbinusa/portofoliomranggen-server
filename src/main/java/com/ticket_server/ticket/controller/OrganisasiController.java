package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.OrganisasiDTO;
import com.ticket_server.ticket.model.Organisasi;
import com.ticket_server.ticket.service.OrganisasiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/organisasi")
public class OrganisasiController {

    private final OrganisasiService organisasiService;

    public OrganisasiController(OrganisasiService organisasiService) {
        this.organisasiService = organisasiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Organisasi>> getAllOrganisasi() {
        return ResponseEntity.ok(organisasiService.getAllOrganisasi());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrganisasiDTO> getOrganisasiById(@PathVariable Long id) {
        Optional<Organisasi> organisasi = organisasiService.getOrganisasiById(id);
        return organisasi.map(org -> {
            OrganisasiDTO dto = new OrganisasiDTO(org);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tambah")
    public ResponseEntity<OrganisasiDTO> tambahOrganisasi(@RequestBody OrganisasiDTO organisasiDTO) {
        return ResponseEntity.ok(organisasiService.tambahOrganisasi(organisasiDTO));
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<OrganisasiDTO> editOrganisasi(@PathVariable Long id, @RequestBody OrganisasiDTO organisasiDTO) {
        return ResponseEntity.ok(organisasiService.editOrganisasi(id, organisasiDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganisasi(@PathVariable Long id) {
        organisasiService.deleteOrganisasi(id);
        return ResponseEntity.noContent().build();
    }
}
