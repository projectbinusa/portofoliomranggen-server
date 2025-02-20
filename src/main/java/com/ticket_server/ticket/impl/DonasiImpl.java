package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.repository.DonasiRepository;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonasiImpl implements DonasiService {
    private final DonasiRepository donasiRepository;

    public DonasiImpl(DonasiRepository donasiRepository) {
        this.donasiRepository = donasiRepository;
    }

    @Override
    public List<Donasi> getAllDonasi() {
        return donasiRepository.findAll();
    }

    @Override
    public List<Donasi> getAllByAdmin(Long idAdmin) {
        return donasiRepository.findAll();
    }

    @Override
    public Optional<DonasiDTO> getDonasiById(Long id) {
        return donasiRepository.findById(id).map(DonasiDTO::new);
    }

    @Override
    public DonasiDTO tambahDonasiDTO(DonasiDTO donasiDTO, Long idAdmin) {
        Donasi donasi = new Donasi();
        donasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        donasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        donasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        donasi.setDeskripsi(donasiDTO.getDeskripsi());
        donasi.setFotoUrl(donasiDTO.getFotoUrl());
        return new DonasiDTO(donasiRepository.save(donasi));
    }

    @Override
    public DonasiDTO editDonasiDTO(Long id, DonasiDTO donasiDTO, Long idAdmin) {
        Donasi donasi = donasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Donasi tidak ditemukan"));
        donasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        donasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        donasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        donasi.setDeskripsi(donasiDTO.getDeskripsi());
        donasi.setFotoUrl(donasiDTO.getFotoUrl());
        return new DonasiDTO(donasiRepository.save(donasi));
    }

    @Override
    public void deleteDonasi(Long id) {
        donasiRepository.deleteById(id);
    }
}