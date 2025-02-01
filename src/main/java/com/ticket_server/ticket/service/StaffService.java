package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.StaffDTO;
import com.ticket_server.ticket.model.Staff;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long id);

    StaffDTO tambahStaff(StaffDTO staffDTO);

    StaffDTO editStaff(Long id, StaffDTO staffDTO) throws IOException;

    StaffDTO editStaff(Long id, String staffJson, MultipartFile file) throws IOException;

    StaffDTO tambahStaffDTO(StaffDTO staffDTO);
    StaffDTO editStaffDTO(Long id, StaffDTO staffDTO) throws IOException;
    void deleteStaff(Long id) throws IOException;
}
