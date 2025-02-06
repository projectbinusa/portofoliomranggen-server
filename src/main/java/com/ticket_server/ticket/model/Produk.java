package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "harga", nullable = false)
    private double harga;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "kondisi", nullable = false)
    private String kondisi; // Baru atau Bekas

    public Produk() {
    }

    public Produk(Long id, String nama, double harga, String deskripsi, String fotoUrl, String kondisi) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.fotoUrl = fotoUrl;
        this.kondisi = kondisi;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getKondisi() { return kondisi; }
    public void setKondisi(String kondisi) { this.kondisi = kondisi; }
}
