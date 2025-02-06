package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Pesanan;

public class PesananDTO {
    private Long id;
    private String namaPesanan; // Nama pesanan ditambahkan
    private int jumlah;
    private double harga;
    private String kondisi;

    public PesananDTO() {}

    public PesananDTO(Pesanan pesanan) {
        this.id = pesanan.getId();
        this.namaPesanan = pesanan.getNamaPesanan(); // Mengambil nama pesanan
        this.jumlah = pesanan.getJumlah();
        this.harga = pesanan.getHarga();
        this.kondisi = pesanan.getKondisi();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaPesanan() { return namaPesanan; } // Getter untuk nama pesanan
    public void setNamaPesanan(String namaPesanan) { this.namaPesanan = namaPesanan; } // Setter untuk nama pesanan

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getKondisi() { return kondisi; }
    public void setKondisi(String kondisi) { this.kondisi = kondisi; }
}
