package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.ProdukDTO;
import com.ticket_server.ticket.model.Produk;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProdukService {
    List<Produk> getAllProduk();
    Optional<Produk> getProdukById(Long id);
    ProdukDTO tambahProdukDTO(ProdukDTO produkDTO);
    ProdukDTO editProdukDTO(Long id, ProdukDTO produkDTO) throws IOException;
    void deleteProduk(Long id) throws IOException;
    String uploadFoto(MultipartFile file) throws IOException;
    List<Produk> getProdukByKondisi(String kondisi);
}