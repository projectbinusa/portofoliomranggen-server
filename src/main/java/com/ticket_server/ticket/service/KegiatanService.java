package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.KegiatanDTO;
import com.ticket_server.ticket.model.Kegiatan;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface KegiatanService {

    // Mendapatkan semua kegiatan
    List<Kegiatan> getAllKegiatan();

    // Mendapatkan kegiatan berdasarkan ID
    Optional<Kegiatan> getKegiatanById(Long id);

    // Menambahkan kegiatan
    KegiatanDTO tambahKegiatan(KegiatanDTO kegiatanDTO);

    // Mengedit kegiatan
    KegiatanDTO editKegiatan(Long id, KegiatanDTO kegiatanDTO) throws IOException;

    // Mengedit kegiatan dengan menerima JSON dan file
    KegiatanDTO editKegiatan(Long id, String kegiatanJson, MultipartFile file) throws IOException;

    // Menambahkan kegiatan menggunakan DTO
    KegiatanDTO tambahKegiatanDTO(KegiatanDTO kegiatanDTO);

    // Mengedit kegiatan menggunakan DTO
    KegiatanDTO editKegiatanDTO(Long id, KegiatanDTO kegiatanDTO) throws IOException;

    // Menghapus kegiatan
    void deleteKegiatan(Long id) throws IOException;
}
