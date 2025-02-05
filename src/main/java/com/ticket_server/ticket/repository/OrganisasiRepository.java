package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Organisasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisasiRepository extends JpaRepository<Organisasi, Long> {}