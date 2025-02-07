package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.PesananDTO;
import com.ticket_server.ticket.model.Pesanan;

import java.util.List;
import java.util.Optional;

public interface PesananService {
    List<Pesanan> getAllPesanan();
    Optional<Pesanan> getPesananById(Long id);
    PesananDTO tambahPesanan(PesananDTO pesananDTO);
    PesananDTO editPesanan(Long id, PesananDTO pesananDTO);
    void deletePesanan(Long id);
}
