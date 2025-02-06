package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BeritaService {
    List<Berita> getAllBerita();
    Optional<Berita> getBeritaById(Long id);
    BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO);
    BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO) throws IOException;
    void deleteBerita(Long id) throws IOException;
}