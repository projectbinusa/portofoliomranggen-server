package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.repository.BeritaRepository;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BeritaImpl implements BeritaService {
    private final BeritaRepository beritaRepository;

    public BeritaImpl(BeritaRepository beritaRepository) {
        this.beritaRepository = beritaRepository;
    }

    @Override
    public List<Berita> getAllBerita() {
        return beritaRepository.findAll();
    }

    @Override
    public List<Berita> getAllByAdmin(Long idAdmin) {
        return beritaRepository.findByIdAdmin(idAdmin);
    }

    @Override
    public Optional<BeritaDTO> getBeritaById(Long id) {
        return beritaRepository.findById(id).map(BeritaDTO::new);
    }

    @Override
    @Transactional
    public BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO, Long idAdmin) {
        Berita berita = new Berita();
        berita.setNama(beritaDTO.getNama());
        berita.setPenulis(beritaDTO.getPenulis());
        berita.setDeskripsi(beritaDTO.getDeskripsi());

        // Set tanggal terbit ke hari ini jika null
        if (beritaDTO.getTanggalTerbit() == null) {
            berita.setTanggalTerbit(LocalDate.now());
        } else {
            berita.setTanggalTerbit(beritaDTO.getTanggalTerbit());
        }

        berita.setFotoUrl(beritaDTO.getFotoUrl());
        berita.setIdAdmin(idAdmin);

        return new BeritaDTO(beritaRepository.save(berita));
    }

    @Override
    @Transactional
    public BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO, Long idAdmin) {
        Berita berita = beritaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Berita tidak ditemukan"));

        berita.setNama(beritaDTO.getNama());
        berita.setPenulis(beritaDTO.getPenulis());
        berita.setDeskripsi(beritaDTO.getDeskripsi());
        berita.setTanggalTerbit(beritaDTO.getTanggalTerbit());
        berita.setFotoUrl(beritaDTO.getFotoUrl());
        berita.setIdAdmin(idAdmin); // Memastikan idAdmin diperbarui juga

        return new BeritaDTO(beritaRepository.save(berita));
    }

    @Override
    @Transactional
    public void deleteBerita(Long id) {
        beritaRepository.deleteById(id);
    }
}