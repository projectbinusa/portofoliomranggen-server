package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Donasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonasiRepository extends JpaRepository<Donasi, Long> {

    List<Donasi> findAll();

    Optional<Donasi> findById(Long id);

    // Jika Anda ingin mencari donasi berdasarkan nama donasi atau nama donatur, bisa tambahkan metode berikut
    List<Donasi> findByNamaDonasi(String namaDonasi);

    List<Donasi> findByNamaDonatur(String namaDonatur);
}
