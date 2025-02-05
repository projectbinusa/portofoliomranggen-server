package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.model.Buku;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BukuService {

    List<Buku> getAllBuku();

    List<Buku> getAllByAdmin(Long idAdmin);

    Optional<Buku> getBukuById(Long id);

    BukuDTO tambahBukuDTO(Long idAdmin, BukuDTO bukuDTO);

    BukuDTO editBukuDTO(Long id, Long idAdmin, String bukuJson, MultipartFile file) throws IOException;

    void deleteBuku(Long id);

    Buku convertToEntity(BukuDTO bukuDTO);

    BukuDTO convertToDTO(Buku buku);
}
