package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Sambutan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SambutanRepository extends JpaRepository<Sambutan, Long> {
    List<Sambutan> findByJudul(String judul);
    List<Sambutan> findByDeskripsi(String deskripsi);
}
