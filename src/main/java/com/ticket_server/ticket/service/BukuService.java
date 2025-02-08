package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BukuService {
    List<Buku> getAllBuku();
    Optional<Buku> getBukuById(Long id);
    BukuDTO tambahBukuDTO(BukuDTO bukuDTO);
    BukuDTO editBukuDTO(Long id, BukuDTO bukuDTO) throws IOException;
    void deleteBuku(Long id) throws IOException;
}