package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.GuruDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.Guru;
import com.ticket_server.ticket.repository.AdminRepository;
import com.ticket_server.ticket.repository.GuruRepository;
import com.ticket_server.ticket.service.GuruService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GuruImpl implements GuruService {

    private final GuruRepository guruRepository;
    private final AdminRepository adminRepository;
    private final ObjectMapper objectMapper;

    public GuruImpl(GuruRepository guruRepository, AdminRepository adminRepository, ObjectMapper objectMapper) {
        this.guruRepository = guruRepository;
        this.adminRepository = adminRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Guru> getAllGuru() {
        return guruRepository.findAll();
    }

    @Override
    public List<Guru> getAllByAdmin(Long idAdmin) {
        return guruRepository.findByAdminId(idAdmin);
    }

    @Override
    public Optional<Guru> getGuruById(Long id) {
        return guruRepository.findById(id);
    }

    @Override
    public GuruDTO tambahGuruDTO(Long idAdmin, GuruDTO guruDTO) {
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin not found"));

        Guru guru = objectMapper.convertValue(guruDTO, Guru.class);
        guru.setAdmin(admin);

        Guru savedGuru = guruRepository.save(guru);
        return objectMapper.convertValue(savedGuru, GuruDTO.class);
    }

    @Override
    public GuruDTO editGuruDTO(Long id, Long idAdmin, String guruJson, MultipartFile file) throws IOException {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guru tidak ditemukan"));

        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin tidak ditemukan"));

        GuruDTO guruDTO = objectMapper.readValue(guruJson, GuruDTO.class);

        guru.setAdmin(admin);
        guru.setNamaGuru(guruDTO.getNamaGuru());
        guru.setHargaGuru(guruDTO.getHargaGuru());

        if (file != null) {
            String base64Image = new String(file.getBytes());
            guru.setFotoUrl(base64Image);
        }

        Guru updatedGuru = guruRepository.save(guru);
        return objectMapper.convertValue(updatedGuru, GuruDTO.class);
    }

    @Override
    public void deleteGuru(Long id) throws IOException {
        guruRepository.deleteById(id);
    }
}
