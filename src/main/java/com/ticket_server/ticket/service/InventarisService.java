package com.ticket_server.ticket.service;

import com.ticket_server.ticket.model.Inventaris;
import com.ticket_server.ticket.repository.InventarisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarisService {

    private final InventarisRepository inventarisRepository;

    public InventarisService(InventarisRepository inventarisRepository) {
        this.inventarisRepository = inventarisRepository;
    }

    public List<Inventaris> getAllInventaris() {
        return inventarisRepository.findAll();
    }

    public Optional<Inventaris> getInventarisById(Long id) {
        return inventarisRepository.findById(id);
    }

    // Modify this method to automatically set adminId from the context or passed parameter
    public Inventaris tambahInventaris(Inventaris inventaris, Long adminId) {
        inventaris.setAdminId(adminId);  // Automatically set adminId
        return inventarisRepository.save(inventaris);
    }

    // Modify this method to automatically set adminId from the context or passed parameter
    public Inventaris editInventaris(Long id, Inventaris inventarisDetails, Long adminId) {
        Optional<Inventaris> optionalInventaris = inventarisRepository.findById(id);
        if (optionalInventaris.isPresent()) {
            Inventaris inventaris = optionalInventaris.get();
            inventaris.setNama(inventarisDetails.getNama());
            inventaris.setDeskripsi(inventarisDetails.getDeskripsi());
            inventaris.setJumlah(inventarisDetails.getJumlah());
            inventaris.setAdminId(adminId); // Automatically set adminId
            return inventarisRepository.save(inventaris);
        }
        return null;
    }

    public void deleteInventaris(Long id) {
        inventarisRepository.deleteById(id);
    }
}

