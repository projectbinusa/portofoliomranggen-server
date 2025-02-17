package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Berita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BeritaRepository extends JpaRepository<Berita, Long> {
    List<Berita> findByIdAdmin(Long idAdmin);
}
