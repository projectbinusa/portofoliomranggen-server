package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.PesananDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Pesanan;
import com.ticket_server.ticket.repository.PesananRepository;
import com.ticket_server.ticket.service.PesananService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesananImpl implements PesananService {
    private final PesananRepository pesananRepository;

    public PesananImpl(PesananRepository pesananRepository) {
        this.pesananRepository = pesananRepository;
    }

    @Override
    public List<Pesanan> getAllPesanan() {
        return pesananRepository.findAll();
    }

    @Override
    public Optional<Pesanan> getPesananById(Long id) {
        return pesananRepository.findById(id);
    }

    @Override
    public PesananDTO tambahPesanan(PesananDTO pesananDTO) {
        Pesanan pesanan = new Pesanan(pesananDTO);
        Pesanan savedPesanan = pesananRepository.save(pesanan);
        return new PesananDTO(savedPesanan);
    }

    @Override
    public PesananDTO editPesanan(Long id, PesananDTO pesananDTO) {
        Pesanan existingPesanan = pesananRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pesanan tidak ditemukan"));

        existingPesanan.setNama(pesananDTO.getNama());
        existingPesanan.setJumlah(pesananDTO.getJumlah());
        existingPesanan.setHarga(pesananDTO.getHarga());
        existingPesanan.setKondisi(pesananDTO.getKondisi());
        existingPesanan.setAksi(pesananDTO.getAksi());

        Pesanan updatedPesanan = pesananRepository.save(existingPesanan);
        return new PesananDTO(updatedPesanan);
    }

    @Override
    public void deletePesanan(Long id) {
        if (!pesananRepository.existsById(id)) {
            throw new NotFoundException("Pesanan tidak ditemukan");
        }
        pesananRepository.deleteById(id);
    }
}
