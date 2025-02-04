package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.StaffDTO;
import com.ticket_server.ticket.model.Staff;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long id);

    StaffDTO tambahStaffDTO(StaffDTO staffDTO);
    StaffDTO editStaffDTO(Long id, StaffDTO staffDTO) throws IOException;
    void deleteStaff(Long id) throws IOException;
}