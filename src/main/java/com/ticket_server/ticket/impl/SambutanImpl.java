package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.SambutanDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Sambutan;
import com.ticket_server.ticket.repository.SambutanRepository;
import com.ticket_server.ticket.service.SambutanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SambutanImpl implements SambutanService {
    private final SambutanRepository sambutanRepository;

    public SambutanImpl(SambutanRepository sambutanRepository) {
        this.sambutanRepository = sambutanRepository;
    }

    @Override
    public List<Sambutan> getAllSambutan() {
        return sambutanRepository.findAll();
    }

    @Override
    public Optional<Sambutan> getSambutanById(Long id) {
        return sambutanRepository.findById(id);
    }

    @Override
    public SambutanDTO tambahSambutan(SambutanDTO sambutanDTO) {
        Sambutan sambutan = new Sambutan();
        sambutan.setJudul(sambutanDTO.getJudul());
        sambutan.setDeskripsi(sambutanDTO.getDeskripsi());  // Ganti 'konten' dengan 'deskripsi'
        sambutan.setCreateDate(sambutanDTO.getCreateDate());

        Sambutan savedSambutan = sambutanRepository.save(sambutan);

        SambutanDTO result = new SambutanDTO();
        result.setId(savedSambutan.getId());
        result.setJudul(savedSambutan.getJudul());
        result.setDeskripsi(savedSambutan.getDeskripsi());  // Ganti 'konten' dengan 'deskripsi'
        result.setCreateDate(savedSambutan.getCreateDate());

        return result;
    }

    @Override
    public SambutanDTO editSambutan(Long id, SambutanDTO sambutanDTO) {
        Sambutan existingSambutan = sambutanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sambutan tidak ditemukan"));

        existingSambutan.setJudul(sambutanDTO.getJudul());
        existingSambutan.setDeskripsi(sambutanDTO.getDeskripsi());  // Ganti 'konten' dengan 'deskripsi'
        existingSambutan.setCreateDate(sambutanDTO.getCreateDate());

        Sambutan updatedSambutan = sambutanRepository.save(existingSambutan);

        SambutanDTO result = new SambutanDTO();
        result.setId(updatedSambutan.getId());
        result.setJudul(updatedSambutan.getJudul());
        result.setDeskripsi(updatedSambutan.getDeskripsi());  // Ganti 'konten' dengan 'deskripsi'
        result.setCreateDate(updatedSambutan.getCreateDate());

        return result;
    }

    @Override
    public void deleteSambutan(Long id) {
        if (!sambutanRepository.existsById(id)) {
            throw new NotFoundException("Sambutan tidak ditemukan");
        }
        sambutanRepository.deleteById(id);
    }
}
