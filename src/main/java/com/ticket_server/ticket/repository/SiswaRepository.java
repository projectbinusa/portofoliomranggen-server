package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {
    // Custom query methods can be added here if needed
}