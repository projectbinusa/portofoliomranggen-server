package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.model.Kelas;
import com.ticket_server.ticket.repository.KelasRepository;
import com.ticket_server.ticket.service.KelasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasImpl extends KelasService {

    private final KelasRepository kelasRepository;

    public KelasImpl(KelasRepository kelasRepository) {
        this.kelasRepository = kelasRepository;
    }

    @Override
    public List<Kelas> getAllKelas() {
        return kelasRepository.findAll();
    }

    @Override
    public Optional<Kelas> getKelasById(Long id) {
        return kelasRepository.findById(id);
    }

    @Override
    public Kelas tambahKelas(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    @Override
    public Kelas editKelas(Long id, Kelas kelas) {
        return kelasRepository.findById(id)
                .map(existingKelas -> {
                    existingKelas.setNamaKelas(kelas.getNamaKelas());
                    return kelasRepository.save(existingKelas);
                })
                .orElseThrow(() -> new RuntimeException("Kelas with ID " + id + " not found"));
    }

    @Override
    public void deleteKelas(Long id) {
        kelasRepository.deleteById(id);
    }
}
