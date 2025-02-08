package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Donasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonasiRepository extends JpaRepository<Donasi, Long> {
}