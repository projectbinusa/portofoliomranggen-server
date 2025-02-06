package com.ticket_server.ticket.controller;

import  com.ticket_server.ticket.DTO.ProdukDTO;
import com.ticket_server.ticket.model.Produk;
import com.ticket_server.ticket.service.ProdukService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProdukController {

    private final ProdukService produkService;

    public ProdukController(ProdukService produkService) {
        this.produkService = produkService;
    }

    @GetMapping("/produk/all")
    public ResponseEntity<List<Produk>> getAllProduk() {
        List<Produk> produkList = produkService.getAllProduk();
        return ResponseEntity.ok(produkList);
    }

    @GetMapping("/produk/getById/{id}")
    public ResponseEntity<ProdukDTO> getProdukById(@PathVariable Long id) {
        Optional<Produk> produk = produkService.getProdukById(id);
        return produk.map(produkEntity -> {
            ProdukDTO produkDTO = new ProdukDTO();
            produkDTO.setId(produkEntity.getId());
            produkDTO.setNama(produkEntity.getNama());
            produkDTO.setHarga(produkEntity.getHarga());
            produkDTO.setDeskripsi(produkEntity.getDeskripsi());
            produkDTO.setKondisi(produkEntity.getKondisi());
            return ResponseEntity.ok(produkDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/produk/tambah")
    public ResponseEntity<ProdukDTO> tambahProduk(@RequestBody ProdukDTO produkDTO) {
        ProdukDTO savedProduk = produkService.tambahProdukDTO(produkDTO);
        return ResponseEntity.ok(savedProduk);
    }

    @PutMapping(value = "/produk/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdukDTO> editProduk(
            @PathVariable Long id,
            @RequestBody ProdukDTO produkDTO) throws IOException {

        ProdukDTO updatedProduk = produkService.editProdukDTO(id, produkDTO);
        return ResponseEntity.ok(updatedProduk);
    }

    @DeleteMapping("/produk/delete/{id}")
    public ResponseEntity<Void> deleteProduk(@PathVariable Long id) throws IOException {
        produkService.deleteProduk(id);
        return ResponseEntity.noContent().build();
    }
}
