package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.GuruDTO;

import java.util.List;

public interface GuruService {
    List<GuruDTO> getAllGuru(); // Ganti return type menjadi GuruDTO

    List<GuruDTO> getAllByAdmin(Long idAdmin); // Ganti return type menjadi GuruDTO

    GuruDTO getGuruById(Long id);

    GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO guruDTO);

    GuruDTO editGuruDTO(Long id, Long idAdmin, GuruDTO guruDTO);

    void deleteGuru(Long id);
}