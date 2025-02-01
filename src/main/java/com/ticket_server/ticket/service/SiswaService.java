package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.SiswaDTO;
import com.ticket_server.ticket.model.Siswa;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SiswaService {
    List<Siswa> getAllSiswa();
    Optional<Siswa> getSiswaById(Long id);
    SiswaDTO tambahSiswaDTO(SiswaDTO siswaDTO);
    SiswaDTO editSiswaDTO(Long id, SiswaDTO siswaDTO) throws IOException;
    void deleteSiswa(Long id) throws IOException;
}