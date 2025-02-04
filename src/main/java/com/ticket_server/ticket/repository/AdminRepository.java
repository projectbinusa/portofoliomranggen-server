package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Admin; // Pastikan import ini ada!
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT * FROM admin WHERE username = :username", nativeQuery = true)
    Optional<Admin> findByUsername(String username);

    @Query(value = "SELECT * FROM admin WHERE email = :email", nativeQuery = true)
    Optional<Admin> findByEmail(String email);
}