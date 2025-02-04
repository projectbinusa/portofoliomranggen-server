package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.KeuanganDTO;
import com.ticket_server.ticket.model.Keuangan;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface KeuanganService {
    List<Keuangan> getAllKeuangan();

    Optional<Keuangan> getKeuanganById(Long id);

    KeuanganDTO tambahKeuanganDTO(KeuanganDTO keuanganDTO);

    KeuanganDTO editKeuanganDTO(Long id, KeuanganDTO keuanganDTO) throws IOException;

    void deleteKeuangan(Long id) throws IOException;
}
