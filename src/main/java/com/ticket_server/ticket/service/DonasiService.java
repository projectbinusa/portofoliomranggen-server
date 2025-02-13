package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import java.util.List;
import java.util.Optional;

public interface DonasiService {
    List<Donasi> getAllDonasi();
    List<Donasi> getAllByAdmin(Long idAdmin);
    Optional<DonasiDTO> getDonasiById(Long id);
    DonasiDTO tambahDonasiDTO(DonasiDTO donasiDTO, Long idAdmin);
    DonasiDTO editDonasiDTO(Long id, DonasiDTO donasiDTO, Long idAdmin);
    void deleteDonasi(Long id);
}
