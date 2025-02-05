package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.OrganisasiDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Organisasi;
import com.ticket_server.ticket.repository.OrganisasiRepository;
import com.ticket_server.ticket.service.OrganisasiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisasiImpl implements OrganisasiService {
    private final OrganisasiRepository organisasiRepository;

    public OrganisasiImpl(OrganisasiRepository organisasiRepository) {
        this.organisasiRepository = organisasiRepository;
    }

    @Override
    public List<Organisasi> getAllOrganisasi() {
        return organisasiRepository.findAll();
    }

    @Override
    public Optional<Organisasi> getOrganisasiById(Long id) {
        return organisasiRepository.findById(id);
    }

    @Override
    public OrganisasiDTO tambahOrganisasi(OrganisasiDTO organisasiDTO) {
        Organisasi organisasi = new Organisasi(organisasiDTO);
        Organisasi savedOrganisasi = organisasiRepository.save(organisasi);
        return new OrganisasiDTO(savedOrganisasi);
    }

    @Override
    public OrganisasiDTO editOrganisasi(Long id, OrganisasiDTO organisasiDTO) {
        Organisasi existingOrganisasi = organisasiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Organisasi tidak ditemukan"));

        existingOrganisasi.setNamaOrganisasi(organisasiDTO.getNamaOrganisasi());
        existingOrganisasi.setLokasi(organisasiDTO.getLokasi());
        existingOrganisasi.setEmail(organisasiDTO.getEmail());
        existingOrganisasi.setTelepon(organisasiDTO.getTelepon());

        Organisasi updatedOrganisasi = organisasiRepository.save(existingOrganisasi);
        return new OrganisasiDTO(updatedOrganisasi);
    }

    @Override
    public void deleteOrganisasi(Long id) {
        if (!organisasiRepository.existsById(id)) {
            throw new NotFoundException("Organisasi tidak ditemukan");
        }
        organisasiRepository.deleteById(id);
    }
}
