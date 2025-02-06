package com.ticket_server.ticket.impl;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Guru;
import com.ticket_server.ticket.repository.GuruRepository;
import com.ticket_server.ticket.service.GuruService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuruImpl implements GuruService {
    private final GuruRepository guruRepository;

    public GuruImpl(GuruRepository guruRepository) {
        this.guruRepository = guruRepository;
    }

    @Override
    public List<GuruDTO> getAllGuru() {
        List<Guru> gurus = guruRepository.findAll();
        return gurus.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public GuruDTO getGuruById(Long id) {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru dengan ID " + id + " tidak ditemukan"));
        return convertToDTO(guru);
    }

    @Override
    public GuruDTO tambahGuruDTO(GuruDTO guruDTO) {
        Guru guru = new Guru();
        guru.setNamaGuru(guruDTO.getNamaGuru());
        guru.setNip(guruDTO.getNip());
        guru.setAlamat(guruDTO.getAlamat());
        guru.setNomerHp(guruDTO.getNomerHp());
        guru.setTahunDiterima(guruDTO.getTahunDiterima());
        guru.setLamaKerja(guruDTO.getLamaKerja());

        // Assuming Admin is already set by a service or from the session context
        guru.setAdmin(new Admin());  // Set the admin properly

        Guru savedGuru = guruRepository.save(guru);
        return convertToDTO(savedGuru);
    }

    @Override
    public GuruDTO editGuruDTO(Long id, GuruDTO guruDTO) {
        Guru existingGuru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru dengan ID " + id + " tidak ditemukan"));

        existingGuru.setNamaGuru(guruDTO.getNamaGuru());
        existingGuru.setNip(guruDTO.getNip());
        existingGuru.setAlamat(guruDTO.getAlamat());
        existingGuru.setNomerHp(guruDTO.getNomerHp());
        existingGuru.setTahunDiterima(guruDTO.getTahunDiterima());
        existingGuru.setLamaKerja(guruDTO.getLamaKerja());

        Guru updatedGuru = guruRepository.save(existingGuru);
        return convertToDTO(updatedGuru);
    }

    @Override
    public boolean deleteGuru(Long id) {
        if (!guruRepository.existsById(id)) {
            return false;
        }
        guruRepository.deleteById(id);
        return true;
    }

    private GuruDTO convertToDTO(Guru guru) {
        GuruDTO guruDTO = new GuruDTO();
        guruDTO.setId(guru.getId());
        guruDTO.setNamaGuru(guru.getNamaGuru());
        guruDTO.setNip(guru.getNip());
        guruDTO.setAlamat(guru.getAlamat());
        guruDTO.setNomerHp(guru.getNomerHp());
        guruDTO.setTahunDiterima(guru.getTahunDiterima());
        guruDTO.setLamaKerja(guru.getLamaKerja());
        guruDTO.setIdAdmin(guru.getAdmin().getId());  // Assuming Admin has an ID
        return guruDTO;
    }
}
