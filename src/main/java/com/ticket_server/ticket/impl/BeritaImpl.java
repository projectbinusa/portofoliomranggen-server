package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.BeritaDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Berita;
import com.ticket_server.ticket.repository.BeritaRepository;
import com.ticket_server.ticket.service.BeritaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeritaImpl implements BeritaService {
    private final BeritaRepository beritaRepository;

    public BeritaImpl(BeritaRepository beritaRepository) {
        this.beritaRepository = beritaRepository;
    }

    @Override
    public List<Berita> getAllBerita(Long idAdmin) {
        return beritaRepository.findByIdAdmin(idAdmin);
    }

    @Override
    public Optional<BeritaDTO> getBeritaById(Long id, Long idAdmin) {
        return beritaRepository.findByIdAndIdAdmin(id, idAdmin).map(BeritaDTO::new);
    }

    @Override
    public BeritaDTO tambahBeritaDTO(BeritaDTO beritaDTO, Long idAdmin) {
        Berita berita = new Berita(beritaDTO);
        berita.setIdAdmin(idAdmin);
        return new BeritaDTO(beritaRepository.save(berita));
    }

    @Override
    public BeritaDTO editBeritaDTO(Long id, BeritaDTO beritaDTO, Long idAdmin) {
        Berita berita = beritaRepository.findByIdAndIdAdmin(id, idAdmin)
                .orElseThrow(() -> new NotFoundException("Berita tidak ditemukan"));

        berita.setNama(beritaDTO.getNama());
        berita.setPenulis(beritaDTO.getPenulis());
        berita.setDeskripsi(beritaDTO.getDeskripsi());
        berita.setFotoUrl(beritaDTO.getFotoUrl());
        berita.setTanggalTerbit(beritaDTO.getTanggalTerbit());
        berita.setAction(beritaDTO.getAction());

        return new BeritaDTO(beritaRepository.save(berita));
    }

    @Override
    public void deleteBerita(Long id, Long idAdmin) {
        if (!beritaRepository.existsByIdAndIdAdmin(id, idAdmin)) {
            throw new NotFoundException("Berita tidak ditemukan");
        }
        beritaRepository.deleteById(id);
    }
}
