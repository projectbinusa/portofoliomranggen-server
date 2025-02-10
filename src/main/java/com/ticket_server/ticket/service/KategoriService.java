package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.KategoriDTO;
import com.ticket_server.ticket.model.Kategori;

import java.util.List;
import java.util.Optional;

public interface KategoriService {
    List<KategoriDTO> getAllKategori();
    Optional<KategoriDTO> getKategoriById(Long id);
    KategoriDTO tambahKategori(Kategori kategoriDTO);
    KategoriDTO editKategori(Long id, Kategori kategoriDTO);
    void deleteKategori(Long id);
}
