package com.ticket_server.ticket.repository;

import com.ticket_server.ticket.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    List<Staff> findAll();

    Optional<Staff> findById(Long id);

    // Jika Anda ingin mencari staff berdasarkan nama atau alamat, Anda bisa menambahkan metode pencarian lainnya
    List<Staff> findByNama(String nama);

    List<Staff> findByAlamat(String alamat);
}