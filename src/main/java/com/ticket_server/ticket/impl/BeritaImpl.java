package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.repository.BeritaRepository;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public Optional<Berita> getBeritaById(Long id) {
        return beritaRepository.findById(id);
    }

    @Override
    public BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO) {
        Berita berita = new Berita();
        berita.setNama(beritaDTO.getNama());
        berita.setPenulis(beritaDTO.getPenulis());
        berita.setDeskripsi(beritaDTO.getDeskripsi());
        berita.setFotoUrl(beritaDTO.getFotoUrl());
        berita.setTanggalTerbit(beritaDTO.getTanggalTerbit());
        berita.setAction(beritaDTO.getAction());

        Berita savedBerita = beritaRepository.save(berita);

        BeritaDTO result = new BeritaDTO();
        result.setId(savedBerita.getId());
        result.setNama(savedBerita.getNama());
        result.setPenulis(savedBerita.getPenulis());
        result.setDeskripsi(savedBerita.getDeskripsi());
        result.setFotoUrl(savedBerita.getFotoUrl());
        result.setTanggalTerbit(savedBerita.getTanggalTerbit());
        result.setAction(savedBerita.getAction());
        return result;
    }

    @Override
    public BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO) {
        Berita existingBerita = beritaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Berita tidak ditemukan"));

        existingBerita.setNama(beritaDTO.getNama());
        existingBerita.setPenulis(beritaDTO.getPenulis());
        existingBerita.setDeskripsi(beritaDTO.getDeskripsi());
        existingBerita.setFotoUrl(beritaDTO.getFotoUrl());
        existingBerita.setTanggalTerbit(beritaDTO.getTanggalTerbit());
        existingBerita.setAction(beritaDTO.getAction());

        Berita updatedBerita = beritaRepository.save(existingBerita);

        BeritaDTO result = new BeritaDTO();
        result.setId(updatedBerita.getId());
        result.setNama(updatedBerita.getNama());
        result.setPenulis(updatedBerita.getPenulis());
        result.setDeskripsi(updatedBerita.getDeskripsi());
        result.setFotoUrl(updatedBerita.getFotoUrl());
        result.setTanggalTerbit(updatedBerita.getTanggalTerbit());
        result.setAction(updatedBerita.getAction());
        return result;
    }

    @Override
    public void deleteBerita(Long id) {
        if (!beritaRepository.existsById(id)) {
            throw new NotFoundException("Berita tidak ditemukan");
        }
        beritaRepository.deleteById(id);
    }
}
