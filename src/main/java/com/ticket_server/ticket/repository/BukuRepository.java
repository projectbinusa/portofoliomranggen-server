package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByAdminId(Long idAdmin);
}
