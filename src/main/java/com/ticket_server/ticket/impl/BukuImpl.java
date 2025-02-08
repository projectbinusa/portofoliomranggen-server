package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.BukuDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Buku;
import com.ticket_server.ticket.repository.BukuRepository;
import com.ticket_server.ticket.service.BukuService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BukuImpl implements BukuService {
    private final BukuRepository bukuRepository;

    public BukuImpl(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Override
    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    @Override
    public Optional<Buku> getBukuById(Long id) {
        return bukuRepository.findById(id);
    }

    @Override
    public BukuDTO tambahBukuDTO(BukuDTO bukuDTO) {
        Buku buku = new Buku();
        buku.setJudulBuku(bukuDTO.getJudulBuku());
        buku.setPenerbit(bukuDTO.getPenerbit());
        buku.setPengarang(bukuDTO.getPengarang());
        buku.setTahunTerbit(bukuDTO.getTahunTerbit());
        buku.setJumlahHalaman(bukuDTO.getJumlahHalaman());
        buku.setFotoUrl(bukuDTO.getFotoUrl());
        buku.setIdAdmin(bukuDTO.getIdAdmin()); // Tambahan idAdmin

        Buku savedBuku = bukuRepository.save(buku);

        BukuDTO result = new BukuDTO();
        result.setId(savedBuku.getId());
        result.setJudulBuku(savedBuku.getJudulBuku());
        result.setPenerbit(savedBuku.getPenerbit());
        result.setPengarang(savedBuku.getPengarang());
        result.setTahunTerbit(savedBuku.getTahunTerbit());
        result.setJumlahHalaman(savedBuku.getJumlahHalaman());
        result.setFotoUrl(savedBuku.getFotoUrl());
        result.setIdAdmin(savedBuku.getIdAdmin());
        return result;
    }

    @Override
    public BukuDTO editBukuDTO(Long id, BukuDTO bukuDTO) {
        Buku existingBuku = bukuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Buku tidak ditemukan"));

        existingBuku.setJudulBuku(bukuDTO.getJudulBuku());
        existingBuku.setPenerbit(bukuDTO.getPenerbit());
        existingBuku.setPengarang(bukuDTO.getPengarang());
        existingBuku.setTahunTerbit(bukuDTO.getTahunTerbit());
        existingBuku.setJumlahHalaman(bukuDTO.getJumlahHalaman());
        existingBuku.setFotoUrl(bukuDTO.getFotoUrl());
        existingBuku.setIdAdmin(bukuDTO.getIdAdmin()); // Tambahan idAdmin

        Buku updatedBuku = bukuRepository.save(existingBuku);

        BukuDTO result = new BukuDTO();
        result.setId(updatedBuku.getId());
        result.setJudulBuku(updatedBuku.getJudulBuku());
        result.setPenerbit(updatedBuku.getPenerbit());
        result.setPengarang(updatedBuku.getPengarang());
        result.setTahunTerbit(updatedBuku.getTahunTerbit());
        result.setJumlahHalaman(updatedBuku.getJumlahHalaman());
        result.setFotoUrl(updatedBuku.getFotoUrl());
        result.setIdAdmin(updatedBuku.getIdAdmin());
        return result;
    }

    @Override
    public void deleteBuku(Long id) {
        if (!bukuRepository.existsById(id)) {
            throw new NotFoundException("Buku tidak ditemukan");
        }
        bukuRepository.deleteById(id);
    }
}