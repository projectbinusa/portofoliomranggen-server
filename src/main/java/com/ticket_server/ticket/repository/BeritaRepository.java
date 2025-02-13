package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Berita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeritaRepository extends JpaRepository<Berita, Long> {}
