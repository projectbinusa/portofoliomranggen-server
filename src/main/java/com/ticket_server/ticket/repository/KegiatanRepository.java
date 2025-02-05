package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Kegiatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan, Long> {

    List<Kegiatan> findAll();

    Optional<Kegiatan> findById(Long id);

    // Pencarian berdasarkan Nama
    List<Kegiatan> findByNama(String nama);

    // Pencarian berdasarkan Penanggung Jawab
    List<Kegiatan> findByPenanggungJawab(String penanggungJawab);
}
