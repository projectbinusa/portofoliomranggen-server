package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.model.VisiMisi;
import com.ticket_server.ticket.repository.VisiMisiRepository;
import com.ticket_server.ticket.service.VisiMisiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisiMisiImpl extends VisiMisiService {

    private final VisiMisiRepository visiMisiRepository;

    public VisiMisiImpl(VisiMisiRepository visiMisiRepository) {
        this.visiMisiRepository = visiMisiRepository;
    }

    @Override
    public List<VisiMisi> getAllVisiMisi() {
        return visiMisiRepository.findAll();
    }

    @Override
    public Optional<VisiMisi> getVisiMisiById(Long id) {
        return visiMisiRepository.findById(id);
    }

    @Override
    public VisiMisi tambahVisiMisi(VisiMisi visiMisi) {
        return visiMisiRepository.save(visiMisi);
    }

    @Override
    public VisiMisi editVisiMisi(Long id, VisiMisi visiMisi) {
        return visiMisiRepository.findById(id)
                .map(existingVisiMisi -> {
                    existingVisiMisi.setVisi(visiMisi.getVisi());
                    existingVisiMisi.setMisi(visiMisi.getMisi());
                    return visiMisiRepository.save(existingVisiMisi);
                })
                .orElseThrow(() -> new RuntimeException("VisiMisi with ID " + id + " not found"));
    }

    @Override
    public void deleteVisiMisi(Long id) {
        visiMisiRepository.deleteById(id);
    }
}
