package com.ticket_server.ticket.service;

import com.ticket_server.ticket.detail.AdminDetail;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.LoginRequest;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.securityNew.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public AdminDetail loadAdminByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> adminOptional = adminRepository.findByEmail(username);
        if (adminOptional.isPresent()) {
            return AdminDetail.buildAdmin(adminOptional.get());
        }
        throw new UsernameNotFoundException("Admin not found with username: " + username);
    }

    public Map<String, Object> authenticate(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        AdminDetail adminDetails = loadAdminByUsername(email);

        if (!passwordEncoder.matches(loginRequest.getPassword(), adminDetails.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        String token = jwtTokenUtil.generateToken(adminDetails);

        Map<String, Object> adminData = new HashMap<>();
        adminData.put("id", adminDetails.getId());
        adminData.put("email", adminDetails.getUsername());
        adminData.put("role", adminDetails.getRole());

        Map<String, Object> response = new HashMap<>();
        response.put("data", adminData);
        response.put("token", token);

        return response;
    }
}
