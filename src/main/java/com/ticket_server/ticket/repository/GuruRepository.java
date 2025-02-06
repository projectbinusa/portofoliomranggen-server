package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Guru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Long> {
    List<Guru> findByAdminId(Long idAdmin);
}
