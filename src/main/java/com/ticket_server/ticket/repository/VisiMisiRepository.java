package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.VisiMisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiMisiRepository extends JpaRepository<VisiMisi, Long> {
}
