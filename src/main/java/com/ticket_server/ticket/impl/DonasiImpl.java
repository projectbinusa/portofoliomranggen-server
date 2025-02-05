package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.DonasiDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Donasi;
import com.ticket_server.ticket.repository.DonasiRepository;
import com.ticket_server.ticket.service.DonasiService;
import org.springframework.stereotype.Service;

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
    public DonasiDTO tambahDonasiDTO(DonasiDTO donasiDTO) {
        Donasi donasi = new Donasi();
        donasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        donasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        donasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        donasi.setTtd(donasiDTO.getTtd());

        Donasi savedDonasi = donasiRepository.save(donasi);

        DonasiDTO result = new DonasiDTO();
        result.setId(savedDonasi.getId());
        result.setNamaDonasi(savedDonasi.getNamaDonasi());
        result.setNamaDonatur(savedDonasi.getNamaDonatur());
        result.setJumlahDonasi(savedDonasi.getJumlahDonasi());
        result.setTtd(savedDonasi.getTtd());

        return result;
    }

    @Override
    public DonasiDTO editDonasiDTO(Long id, DonasiDTO donasiDTO) {
        Donasi existingDonasi = donasiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Donasi tidak ditemukan"));

        existingDonasi.setNamaDonasi(donasiDTO.getNamaDonasi());
        existingDonasi.setNamaDonatur(donasiDTO.getNamaDonatur());
        existingDonasi.setJumlahDonasi(donasiDTO.getJumlahDonasi());
        existingDonasi.setTtd(donasiDTO.getTtd());

        Donasi updatedDonasi = donasiRepository.save(existingDonasi);

        DonasiDTO result = new DonasiDTO();
        result.setId(updatedDonasi.getId());
        result.setNamaDonasi(updatedDonasi.getNamaDonasi());
        result.setNamaDonatur(updatedDonasi.getNamaDonatur());
        result.setJumlahDonasi(updatedDonasi.getJumlahDonasi());
        result.setTtd(updatedDonasi.getTtd());

        return result;
    }

    @Override
    public void deleteDonasi(Long id) {
        if (!donasiRepository.existsById(id)) {
            throw new NotFoundException("Donasi tidak ditemukan");
        }
        donasiRepository.deleteById(id);
    }
}
