package com.ticket_server.ticket.service;

import com.ticket_server.ticket.model.Kelas;
import com.ticket_server.ticket.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    public List<Kelas> getAllKelas() {
        return kelasRepository.findAll();
    }

    public Optional<Kelas> getKelasById(Long id) {
        return kelasRepository.findById(id);
    }

    public Kelas tambahKelas(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    public Kelas editKelas(Long id, Kelas kelas) {
        if (kelasRepository.existsById(id)) {
            kelas.setId(id);
            return kelasRepository.save(kelas);
        }
        return null;
    }

    public void deleteKelas(Long id) {
        kelasRepository.deleteById(id);
    }
}