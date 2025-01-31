package com.ticket_server.ticket.service;

import com.ticket_server.ticket.detail.AdminDetail;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.LoginRequest;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.securityNew.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminDetail loadAdminByUsername(String username) {
        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent()) {
            return AdminDetail.buildAdmin(adminOptional.get());
        }
        throw new IllegalArgumentException("Admin not found with username: " + username);
    }

    public Map<String, Object> authenticate(LoginRequest loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Map<String, Object> response = new HashMap<>();

        try {
            // Cek apakah pengguna adalah Admin
            AdminDetail adminDetails = loadAdminByUsername(username);
            if (passwordEncoder.matches(password, adminDetails.getPassword())) {
                String token = jwtTokenUtil.generateToken(adminDetails);

                Map<String, Object> adminData = new HashMap<>();
                adminData.put("id", adminDetails.getId());
                adminData.put("username", adminDetails.getUsername());
                adminData.put("role", adminDetails.getRole());

                response.put("userData", adminData);
                response.put("token", token);
                return response;
            }
        } catch (IllegalArgumentException ignored) {
            // Jika tidak ditemukan sebagai Admin, lempar exception
        }

        throw new BadCredentialsException("Username atau password salah");
    }
}
