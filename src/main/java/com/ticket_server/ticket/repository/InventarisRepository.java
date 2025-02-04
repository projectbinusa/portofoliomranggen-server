package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Inventaris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarisRepository extends JpaRepository<Inventaris, Long> {
}
