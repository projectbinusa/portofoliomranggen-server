package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.repository.DonasiRepository;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public Optional<Donasi> getDonasiById(Long id) {
        return donasiRepository.findById(id);
    }

    @Override
    public DonasiDTO tambahDonasi(DonasiDTO donasiDTO) {
        Donasi donasi = new Donasi();
        donasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        donasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        donasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        donasi.setFotoUrl(donasiDTO.getFotoUrl());
        donasi.setDeskripsi(donasiDTO.getDeskripsi());

        Donasi savedDonasi = donasiRepository.save(donasi);
        return new DonasiDTO(savedDonasi);
    }

    @Override
    public DonasiDTO editDonasi(Long id, DonasiDTO donasiDTO) {
        Donasi existingDonasi = donasiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Donasi tidak ditemukan"));

        existingDonasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        existingDonasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        existingDonasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        existingDonasi.setFotoUrl(donasiDTO.getFotoUrl());
        existingDonasi.setDeskripsi(donasiDTO.getDeskripsi());

        Donasi updatedDonasi = donasiRepository.save(existingDonasi);
        return new DonasiDTO(updatedDonasi);
    }

    @Override
    public void deleteDonasi(Long id) {
        if (!donasiRepository.existsById(id)) {
            throw new NotFoundException("Donasi tidak ditemukan");
        }
        donasiRepository.deleteById(id);
    }

    @Override
    public String uploadFoto(MultipartFile file) throws IOException {
        return null;
    }
}
