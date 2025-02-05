package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.OrganisasiDTO;
import com.ticket_server.ticket.model.Organisasi;

import java.util.List;
import java.util.Optional;

public interface OrganisasiService {
    List<Organisasi> getAllOrganisasi();
    Optional<Organisasi> getOrganisasiById(Long id);
    OrganisasiDTO tambahOrganisasi(OrganisasiDTO organisasiDTO);
    OrganisasiDTO editOrganisasi(Long id, OrganisasiDTO organisasiDTO);
    void deleteOrganisasi(Long id);
}
