package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Donasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonasiRepository extends JpaRepository<Donasi, Long> {
    List<Donasi> findAll();
    Optional<Donasi> findById(Long id);
    List<Donasi> findByAdminId(Long idAdmin);
}
