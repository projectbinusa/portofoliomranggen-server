package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
    List<Produk> findAll();
    Optional<Produk> findById(Long id);
    List<Produk> findByNama(String nama);
    List<Produk> findByKondisi(String kondisi);
}