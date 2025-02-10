package com.ticket_server.ticket.service;

import com.ticket_server.ticket.model.VisiMisi;
import com.ticket_server.ticket.repository.VisiMisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisiMisiService {

    @Autowired
    private VisiMisiRepository visiMisiRepository;

    public List<VisiMisi> getAllVisiMisi() {
        return visiMisiRepository.findAll();
    }

    public Optional<VisiMisi> getVisiMisiById(Long id) {
        return visiMisiRepository.findById(id);
    }

    public VisiMisi tambahVisiMisi(VisiMisi visiMisi) {
        return visiMisiRepository.save(visiMisi);
    }

    public VisiMisi editVisiMisi(Long id, VisiMisi visiMisi) {
        if (visiMisiRepository.existsById(id)) {
            visiMisi.setId(id);
            return visiMisiRepository.save(visiMisi);
        }
        return null;
    }

    public void deleteVisiMisi(Long id) {
        visiMisiRepository.deleteById(id);
    }
}
