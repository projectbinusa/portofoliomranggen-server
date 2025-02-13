package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DonasiService {
    List<Donasi> getAllDonasi();

    Optional<Donasi> getDonasiById(Long id);

    DonasiDTO tambahDonasi(Long idAdmin, DonasiDTO donasiDTO);

    DonasiDTO editDonasi(Long id, Long idAdmin, String donasiJson, MultipartFile file) throws IOException;

    String uploadFoto(MultipartFile file) throws IOException;

    void deleteDonasi(Long id) throws IOException;
}