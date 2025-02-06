package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DonasiService {
    List<Donasi> getAllDonasi();
    Optional<Donasi> getDonasiById(Long id);

    DonasiDTO tambahDonasiDTO(DonasiDTO donasiDTO);
    DonasiDTO editDonasiDTO(Long id, DonasiDTO donasiDTO) throws IOException;
    void deleteDonasi(Long id) throws IOException;
}
