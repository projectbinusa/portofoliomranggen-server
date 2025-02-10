package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.KategoriDTO;
import com.ticket_server.ticket.model.Kategori;
import com.ticket_server.ticket.repository.KategoriRepository;
import com.ticket_server.ticket.service.KategoriService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KategoriImpl implements KategoriService {
    private KategoriRepository kategoriRepository;

    public void KategoriServiceImpl(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public KategoriImpl(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    @Override
    public List<KategoriDTO> getAllKategori() {
        List<Kategori> kategoriList = kategoriRepository.findAll();
        return kategoriList.stream()
                .map(kategori -> new KategoriDTO(kategori.getId(), kategori.getNamaKategori()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KategoriDTO> getKategoriById(Long id) {
        return kategoriRepository.findById(id)
                .map(kategori -> new KategoriDTO(kategori.getId(), kategori.getNamaKategori()));
    }

    @Override
    public KategoriDTO tambahKategori(Kategori kategoriDTO) {
        Kategori kategori = new Kategori();
        kategori.setNamaKategori(kategoriDTO.getNamaKategori());
        Kategori savedKategori = kategoriRepository.save(kategori);
        return new KategoriDTO(savedKategori.getId(), savedKategori.getNamaKategori());
    }

    @Override
    public KategoriDTO editKategori(Long id, Kategori kategoriDTO) {
        Optional<Kategori> kategoriOpt = kategoriRepository.findById(id);
        if (kategoriOpt.isPresent()) {
            Kategori kategori = kategoriOpt.get();
            kategori.setNamaKategori(kategoriDTO.getNamaKategori());
            Kategori updatedKategori = kategoriRepository.save(kategori);
            return new KategoriDTO(updatedKategori.getId(), updatedKategori.getNamaKategori());
        }
        return null;
    }

    @Override
    public void deleteKategori(Long id) {
        kategoriRepository.deleteById(id);
    }
}
