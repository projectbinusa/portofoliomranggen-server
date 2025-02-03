package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.model.Guru;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface GuruService {
    List<Guru> getAllGuru();

    List<Guru> getAllByAdmin(Long idAdmin);

    Optional<Guru> getGuruById(Long id);

    GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO tokoDTO);

    GuruDTO editGuruDTO(Long id, Long idAdmin, String tokoJson, MultipartFile file) throws IOException;

    void deleteGuru(Long id) throws IOException;
}