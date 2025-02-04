package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "keuangan")
public class Keuangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "harga", nullable = false)
    private double harga;

    @Column(name = "jumlah", nullable = false)
    private int jumlah;

    @Column(name = "total_harga", nullable = false)
    private double totalHarga;

    @Column(name = "kategori_pembiayaan", nullable = false)
    private String kategoriPembiayaan;

    @Column(name = "catatan")
    private String catatan;

    public Keuangan() {
    }

    public Keuangan(Long id, String nama, double harga, int jumlah, double totalHarga, String kategoriPembiayaan, String catatan) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.kategoriPembiayaan = kategoriPembiayaan;
        this.catatan = catatan;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }

    public void setHarga(double harga) { this.harga = harga; }

    public int getJumlah() { return jumlah; }

    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getTotalHarga() { return totalHarga; }

    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }

    public String getKategoriPembiayaan() { return kategoriPembiayaan; }

    public void setKategoriPembiayaan(String kategoriPembiayaan) { this.kategoriPembiayaan = kategoriPembiayaan; }

    public String getCatatan() { return catatan; }

    public void setCatatan(String catatan) { this.catatan = catatan; }
}
