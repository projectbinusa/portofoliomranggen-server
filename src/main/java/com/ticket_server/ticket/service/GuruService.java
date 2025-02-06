package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.GuruDTO;

import java.util.List;

public interface GuruService {
    List<GuruDTO> getAllGuru(); // Changed return type to GuruDTO

    List<GuruDTO> getAllByAdmin(Long idAdmin); // Changed return type to GuruDTO

    GuruDTO getGuruById(Long id);

    GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO guruDTO);

    GuruDTO editGuruDTO(Long id, Long idAdmin, GuruDTO guruDTO);

    void deleteGuru(Long id);
}
