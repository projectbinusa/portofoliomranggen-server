package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import java.util.List;
import java.util.Optional;

public interface BeritaService {
    List<Berita> getAllBerita();
    List<Berita> getAllByAdmin(Long idAdmin);
    Optional<BeritaDTO> getBeritaById(Long id);
    BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO, Long idAdmin);
    BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO, Long idAdmin);
    void deleteBerita(Long id);
}