package com.ticket_server.ticket.model;

import com.ticket_server.ticket.DTO.PesananDTO;

import javax.persistence.*;

@Entity
@Table(name = "pesanan")
public class Pesanan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_pesanan", nullable = false) // Mengganti nama menjadi nama_pesanan
    private String namaPesanan;

    @Column(name = "jumlah", nullable = false)
    private int jumlah;

    @Column(name = "harga", nullable = false)
    private double harga;

    @Column(name = "kondisi", nullable = false)
    private String kondisi;

    public Pesanan() {}

    public Pesanan(PesananDTO dto) {
        this.namaPesanan = dto.getNamaPesanan(); // Menggunakan namaPesanan dari DTO
        this.jumlah = dto.getJumlah();
        this.harga = dto.getHarga();
        this.kondisi = dto.getKondisi();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaPesanan() { return namaPesanan; }
    public void setNamaPesanan(String namaPesanan) { this.namaPesanan = namaPesanan; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getKondisi() { return kondisi; }
    public void setKondisi(String kondisi) { this.kondisi = kondisi; }
}
