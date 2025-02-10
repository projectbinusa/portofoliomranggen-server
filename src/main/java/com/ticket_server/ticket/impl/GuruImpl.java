package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.Guru;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.repository.GuruRepository;
import com.ticket_server.ticket.service.GuruService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GuruImpl implements GuruService {

    private final GuruRepository guruRepository;
    private final AdminRepository adminRepository;

    public GuruImpl(GuruRepository guruRepository, AdminRepository adminRepository) {
        this.guruRepository = guruRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<GuruDTO> getAllGuru() {
        return guruRepository.findAll().stream()
                .map(GuruDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuruDTO> getAllByAdmin(Long idAdmin) {
        return guruRepository.findByAdminId(idAdmin).stream()
                .map(GuruDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public GuruDTO getGuruById(Long id) {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru tidak ditemukan"));
        return new GuruDTO(guru);
    }

    @Override
    public GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO guruDTO) {
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin tidak ditemukan"));

        Guru guru = new Guru();
        guru.setAdmin(admin);
        guru.setNamaGuru(guruDTO.getNamaGuru());
        guru.setNip(guruDTO.getNip());  // Tetap sebagai Long
        guru.setAlamat(guruDTO.getAlamat());
        guru.setNomerHp(guruDTO.getNomerHp());  // Tetap sebagai Long
        guru.setTahunDiterima(String.valueOf(guruDTO.getTahunDiterima()));
        guru.setLamaKerja(String.valueOf(guruDTO.getLamaKerja()));

        Guru savedGuru = guruRepository.save(guru);
        return new GuruDTO(savedGuru);
    }

    @Override
    public GuruDTO editGuruDTO(Long id, Long idAdmin, GuruDTO guruDTO) {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru tidak ditemukan"));

        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin tidak ditemukan"));

        guru.setAdmin(admin);
        guru.setNamaGuru(guruDTO.getNamaGuru());
        guru.setNip(guruDTO.getNip());  // Tetap sebagai Long
        guru.setAlamat(guruDTO.getAlamat());
        guru.setNomerHp(guruDTO.getNomerHp());  // Tetap sebagai Long
        guru.setTahunDiterima(String.valueOf(guruDTO.getTahunDiterima()));
        guru.setLamaKerja(String.valueOf(guruDTO.getLamaKerja()));

        Guru updatedGuru = guruRepository.save(guru);
        return new GuruDTO(updatedGuru);
    }

    @Override
    public void deleteGuru(Long id) {
        if (!guruRepository.existsById(id)) {
            throw new NotFoundException("Guru tidak ditemukan");
        }
        guruRepository.deleteById(id);
    }
}
