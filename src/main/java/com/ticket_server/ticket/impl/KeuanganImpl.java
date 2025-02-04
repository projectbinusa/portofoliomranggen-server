package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.KeuanganDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Keuangan;
import com.ticket_server.ticket.repository.KeuanganRepository;
import com.ticket_server.ticket.service.KeuanganService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeuanganImpl implements KeuanganService {
    private final KeuanganRepository keuanganRepository;

    public KeuanganImpl(KeuanganRepository keuanganRepository) {
        this.keuanganRepository = keuanganRepository;
    }

    @Override
    public List<Keuangan> getAllKeuangan() {
        return keuanganRepository.findAll();
    }

    @Override
    public Optional<Keuangan> getKeuanganById(Long id) {
        return keuanganRepository.findById(id);
    }

    @Override
    public KeuanganDTO tambahKeuanganDTO(KeuanganDTO keuanganDTO) {
        Keuangan keuangan = new Keuangan();
        keuangan.setNama(keuanganDTO.getNama());
        keuangan.setHarga(keuanganDTO.getHarga());
        keuangan.setJumlah(keuanganDTO.getJumlah());
        keuangan.setKategoriPembiayaan(keuanganDTO.getKategoriPembiayaan());
        keuangan.setCatatan(keuanganDTO.getCatatan());

        // Calculate Total Harga before saving
        keuanganDTO.calculateTotalHarga();
        keuangan.setTotalHarga(keuanganDTO.getTotalHarga());

        Keuangan savedKeuangan = keuanganRepository.save(keuangan);

        KeuanganDTO result = new KeuanganDTO();
        result.setId(savedKeuangan.getId());
        result.setNama(savedKeuangan.getNama());
        result.setHarga(savedKeuangan.getHarga());
        result.setJumlah(savedKeuangan.getJumlah());
        result.setTotalHarga(savedKeuangan.getTotalHarga());
        result.setKategoriPembiayaan(savedKeuangan.getKategoriPembiayaan());
        result.setCatatan(savedKeuangan.getCatatan());
        return result;
    }

    @Override
    public KeuanganDTO editKeuanganDTO(Long id, KeuanganDTO keuanganDTO) {
        Keuangan existingKeuangan = keuanganRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Keuangan tidak ditemukan"));

        existingKeuangan.setNama(keuanganDTO.getNama());
        existingKeuangan.setHarga(keuanganDTO.getHarga());
        existingKeuangan.setJumlah(keuanganDTO.getJumlah());
        existingKeuangan.setKategoriPembiayaan(keuanganDTO.getKategoriPembiayaan());
        existingKeuangan.setCatatan(keuanganDTO.getCatatan());

        // Recalculate Total Harga before saving
        keuanganDTO.calculateTotalHarga();
        existingKeuangan.setTotalHarga(keuanganDTO.getTotalHarga());

        Keuangan updatedKeuangan = keuanganRepository.save(existingKeuangan);

        KeuanganDTO result = new KeuanganDTO();
        result.setId(updatedKeuangan.getId());
        result.setNama(updatedKeuangan.getNama());
        result.setHarga(updatedKeuangan.getHarga());
        result.setJumlah(updatedKeuangan.getJumlah());
        result.setTotalHarga(updatedKeuangan.getTotalHarga());
        result.setKategoriPembiayaan(updatedKeuangan.getKategoriPembiayaan());
        result.setCatatan(updatedKeuangan.getCatatan());
        return result;
    }

    @Override
    public void deleteKeuangan(Long id) {
        if (!keuanganRepository.existsById(id)) {
            throw new NotFoundException("Keuangan tidak ditemukan");
        }
        keuanganRepository.deleteById(id);
    }
}
