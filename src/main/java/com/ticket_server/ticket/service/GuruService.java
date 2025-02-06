package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.GuruDTO;

import java.util.List;

public interface GuruService {
    List<GuruDTO> getAllGuru();
    GuruDTO getGuruById(Long id);
    GuruDTO tambahGuruDTO(GuruDTO guruDTO);
    GuruDTO editGuruDTO(Long id, GuruDTO guruDTO);
    void deleteGuru(Long id);
}
