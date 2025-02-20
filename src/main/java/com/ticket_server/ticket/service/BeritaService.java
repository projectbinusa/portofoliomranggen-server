package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import java.util.List;
import java.util.Optional;

public interface BeritaService {
    List<Berita> getAllBerita();
    List<Berita> getAllByAdmin(Long idAdmin);
    Optional<Berita> getBeritaById(Long id);
    BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO);
    BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO);
    void deleteBerita(Long id);
}