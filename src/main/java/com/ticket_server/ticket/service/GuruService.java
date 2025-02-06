package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.GuruDTO;

import java.util.List;

public interface GuruService {
    List<GuruDTO> getAllGuru(); // Returns a list of GuruDTO objects

    List<GuruDTO> getAllByAdmin(Long idAdmin); // Returns a list of GuruDTO objects filtered by admin ID

    GuruDTO getGuruById(Long id); // Returns a single GuruDTO based on the provided Guru ID

    GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO guruDTO); // Adds a new GuruDTO and returns the saved GuruDTO

    GuruDTO editGuruDTO(Long id, Long idAdmin, GuruDTO guruDTO); // Edits an existing GuruDTO and returns the updated GuruDTO

    void deleteGuru(Long id); // Deletes a Guru by its ID
}
