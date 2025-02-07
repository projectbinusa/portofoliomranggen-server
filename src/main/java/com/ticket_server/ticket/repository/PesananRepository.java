package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesananRepository extends JpaRepository<Pesanan, Long> {}
