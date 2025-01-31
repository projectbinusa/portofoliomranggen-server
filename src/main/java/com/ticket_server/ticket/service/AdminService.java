package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.PasswordDTO;
import com.ticket_server.ticket.model.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {

    Admin registerAdmin(Admin admin);  // Ganti User dengan Admin

    Admin getById(Long id);  // Ganti User dengan Admin

    List<Admin> getAll();  // Ganti User dengan Admin

    Admin edit(Long id, Admin admin);  // Ganti User dengan Admin

    Admin putPasswordAdmin(PasswordDTO passwordDTO, Long id);  // Ganti User dengan Admin

    Map<String, Boolean> delete(Long id);  // Ganti User dengan Admin
}