package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Guru;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.repository.GuruRepository;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.service.GuruService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GuruImpl implements GuruService {

    private static final Logger logger = LoggerFactory.getLogger(GuruImpl.class);
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
    public GuruDTO getGuruById(Long id) {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru tidak ditemukan"));
        return new GuruDTO(guru);
    }

    @Override
    public GuruDTO tambahGuruDTO(GuruDTO guruDTO) {
        logger.info("Mengecek keberadaan Admin dengan ID: {}", guruDTO.getIdAdmin());
        Admin admin = adminRepository.findById(guruDTO.getIdAdmin())
                .orElseThrow(() -> new NotFoundException("Admin dengan ID " + guruDTO.getIdAdmin() + " tidak ditemukan"));

        Guru guru = guruDTO.toEntity(admin);
        Guru savedGuru = guruRepository.save(guru);
        return new GuruDTO(savedGuru);
    }

    @Override
    public GuruDTO editGuruDTO(Long id, GuruDTO guruDTO) {
        logger.info("Mengedit Guru ID: {}, dengan Admin ID: {}", id, guruDTO.getIdAdmin());

        Guru existingGuru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru tidak ditemukan"));

        Admin admin = adminRepository.findById(guruDTO.getIdAdmin())
                .orElseThrow(() -> new NotFoundException("Admin dengan ID " + guruDTO.getIdAdmin() + " tidak ditemukan"));

        existingGuru.setNamaGuru(guruDTO.getNamaGuru());
        existingGuru.setNip(guruDTO.getNip());
        existingGuru.setAlamat(guruDTO.getAlamat());
        existingGuru.setNomerHp(guruDTO.getNomerHp());
        existingGuru.setTahunDiterima(guruDTO.getTahunDiterima());
        existingGuru.setLamaKerja(guruDTO.getLamaKerja());
        existingGuru.setAdmin(admin);

        Guru updatedGuru = guruRepository.save(existingGuru);
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
