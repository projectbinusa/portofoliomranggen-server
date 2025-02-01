package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.StaffDTO;
import com.ticket_server.ticket.model.Staff;
import com.ticket_server.ticket.service.StaffService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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
        if (staffList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(staffList);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.getStaffById(id);
        return staff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/staff/tambah")
    public ResponseEntity<StaffDTO> tambahStaff(
            @RequestParam("staff") String staffJson,
            @RequestParam("file") MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StaffDTO staffDTO = objectMapper.readValue(staffJson, StaffDTO.class);
//        String fotoUrl = staffService.uploadFoto(file);
//        staffDTO.setFotoUrl(fotoUrl);
        StaffDTO savedStaff = staffService.tambahStaff(staffDTO);
        return ResponseEntity.ok(savedStaff);
    }

    @PutMapping("/staff/edit/{id}")
    public ResponseEntity<StaffDTO> editStaff(
            @PathVariable Long id,
            @RequestParam("staff") String staffJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        StaffDTO updatedStaff = staffService.editStaff(id, staffJson, file);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/staff/delete/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
