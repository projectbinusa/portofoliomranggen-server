package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.ProdukDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Produk;
import com.ticket_server.ticket.repository.ProdukRepository;
import com.ticket_server.ticket.service.ProdukService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdukImpl implements ProdukService {
    private final ProdukRepository produkRepository;

    public ProdukImpl(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;
    }

    @Override
    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    @Override
    public Optional<Produk> getProdukById(Long id) {
        return produkRepository.findById(id);
    }

    @Override
    public ProdukDTO tambahProdukDTO(ProdukDTO produkDTO) {
        Produk produk = new Produk();
        produk.setNama(produkDTO.getNama());
        produk.setHarga(produkDTO.getHarga());
        produk.setDeskripsi(produkDTO.getDeskripsi());
        produk.setFotoUrl(produkDTO.getFotoUrl());
        produk.setKondisi(produkDTO.getKondisi());

        Produk savedProduk = produkRepository.save(produk);

        ProdukDTO result = new ProdukDTO();
        result.setId(savedProduk.getId());
        result.setNama(savedProduk.getNama());
        result.setHarga(savedProduk.getHarga());
        result.setDeskripsi(savedProduk.getDeskripsi());
        result.setFotoUrl(savedProduk.getFotoUrl());
        result.setKondisi(savedProduk.getKondisi());
        return result;
    }

    @Override
    public ProdukDTO editProdukDTO(Long id, ProdukDTO produkDTO) {
        Produk existingProduk = produkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produk tidak ditemukan"));

        existingProduk.setNama(produkDTO.getNama());
        existingProduk.setHarga(produkDTO.getHarga());
        existingProduk.setDeskripsi(produkDTO.getDeskripsi());
        existingProduk.setFotoUrl(produkDTO.getFotoUrl());
        existingProduk.setKondisi(produkDTO.getKondisi());

        Produk updatedProduk = produkRepository.save(existingProduk);

        ProdukDTO result = new ProdukDTO();
        result.setId(updatedProduk.getId());
        result.setNama(updatedProduk.getNama());
        result.setHarga(updatedProduk.getHarga());
        result.setDeskripsi(updatedProduk.getDeskripsi());
        result.setFotoUrl(updatedProduk.getFotoUrl());
        result.setKondisi(updatedProduk.getKondisi());
        return result;
    }

    @Override
    public void deleteProduk(Long id) {
        if (!produkRepository.existsById(id)) {
            throw new NotFoundException("Produk tidak ditemukan");
        }
        produkRepository.deleteById(id);
    }

    @Override
    public String uploadFoto(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public List<Produk> getProdukByKondisi(String kondisi) {
        return produkRepository.findByKondisi(kondisi);
    }
}
