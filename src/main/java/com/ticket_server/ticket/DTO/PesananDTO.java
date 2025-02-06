package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Pesanan;

public class PesananDTO {
    private Long id;
    private String nama;
    private int jumlah;
    private double harga;
    private String kondisi;
    private String aksi;

    public PesananDTO() {}

    public PesananDTO(Pesanan pesanan) {
        this.id = pesanan.getId();
        this.nama = pesanan.getNama();
        this.jumlah = pesanan.getJumlah();
        this.harga = pesanan.getHarga();
        this.kondisi = pesanan.getKondisi();
        this.aksi = pesanan.getAksi();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getKondisi() { return kondisi; }
    public void setKondisi(String kondisi) { this.kondisi = kondisi; }

    public String getAksi() { return aksi; }
    public void setAksi(String aksi) { this.aksi = aksi; }
}
