package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Keuangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeuanganRepository extends JpaRepository<Keuangan, Long> {

    List<Keuangan> findAll();

    Optional<Keuangan> findById(Long id);

    // If you want to search for Keuangan by nama or kategoriPembiayaan, you can add these methods
    List<Keuangan> findByNama(String nama);

    List<Keuangan> findByKategoriPembiayaan(String kategoriPembiayaan);
}
