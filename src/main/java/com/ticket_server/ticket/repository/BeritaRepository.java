package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Berita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeritaRepository extends JpaRepository<Berita, Long> {

    // Mengambil semua berita berdasarkan idAdmin
    List<Berita> findByIdAdmin(Long idAdmin);

    // Mencari berita berdasarkan id dan idAdmin
    Optional<Berita> findByIdAndIdAdmin(Long id, Long idAdmin);

    // Mengecek apakah berita dengan id dan idAdmin tertentu ada di database
    boolean existsByIdAndIdAdmin(Long id, Long idAdmin);
}
