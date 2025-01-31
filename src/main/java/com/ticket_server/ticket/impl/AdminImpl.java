package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.PasswordDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.exception.BadRequestException;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder encoder;

    public AdminImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin registerAdmin(Admin admin) {
        // Cek apakah email sudah digunakan
        Optional<Admin> existingEmail = adminRepository.findByEmail(admin.getEmail());
        if (existingEmail.isPresent()) {
            throw new BadRequestException("Email sudah digunakan");
        }

        // Cek apakah username sudah digunakan
        Optional<Admin> existingUsername = adminRepository.findByUsername(admin.getUsername());
        if (existingUsername.isPresent()) {
            throw new BadRequestException("Username sudah digunakan");
        }

        // Tetapkan peran sebagai "ADMIN" secara default
        admin.setRole("ADMIN");

        // Enkripsi password sebelum disimpan
        admin.setPassword(encoder.encode(admin.getPassword()));

        // Simpan dan kembalikan admin yang terdaftar
        return adminRepository.save(admin);
    }

    @Override
    public Admin getById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Admin Tidak Ditemukan"));
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin edit(Long id, Admin admin) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin Tidak Ditemukan"));

        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setEmail(admin.getEmail());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public Admin putPasswordAdmin(PasswordDTO passwordDTO, Long id) {
        Admin update = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));

        boolean isOldPasswordCorrect = encoder.matches(passwordDTO.getOld_password(), update.getPassword());

        if (!isOldPasswordCorrect) {
            throw new BadRequestException("Password Lama Tidak Sesuai");
        }

        if (passwordDTO.getNew_password().equals(passwordDTO.getConfirm_new_password())) {
            update.setPassword(encoder.encode(passwordDTO.getNew_password()));
            return adminRepository.save(update);
        } else {
            throw new BadRequestException("Password Baru Tidak Sesuai");
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            adminRepository.deleteById(id);
            response.put("Deleted", Boolean.TRUE);
        } catch (Exception e) {
            response.put("Deleted", Boolean.FALSE);
        }
        return response;
    }
}