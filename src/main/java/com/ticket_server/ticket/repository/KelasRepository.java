package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long> {
}
