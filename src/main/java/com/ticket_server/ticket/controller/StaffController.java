package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.StaffDTO;
import com.ticket_server.ticket.model.Staff;
import com.ticket_server.ticket.service.StaffService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staff/all")
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        return ResponseEntity.ok(staffList);
    }

    @GetMapping("/staff/getById/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.getStaffById(id);
        return staff.map(staffEntity -> {
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setId(staffEntity.getId());
            staffDTO.setNama(staffEntity.getNama());
            staffDTO.setAlamat(staffEntity.getAlamat());
            staffDTO.setNoTelepon(staffEntity.getNoTelepon());
            staffDTO.setAwalBekerja(staffEntity.getAwalBekerja());
            staffDTO.setLamaKerja(staffEntity.getLamaKerja());
            staffDTO.setCreateDate(staffEntity.getCreateDate());
            return ResponseEntity.ok(staffDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/staff/tambah")
    public ResponseEntity<StaffDTO> tambahStaff(@RequestBody StaffDTO staffDTO) {
        StaffDTO savedStaff = staffService.tambahStaffDTO(staffDTO);
        return ResponseEntity.ok(savedStaff);
    }

    @PutMapping(value = "/staff/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StaffDTO> editStaff(
            @PathVariable Long id,
            @RequestBody StaffDTO staffDTO) throws IOException {

        StaffDTO updatedStaff = staffService.editStaffDTO(id, staffDTO);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/staff/delete/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) throws IOException {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}