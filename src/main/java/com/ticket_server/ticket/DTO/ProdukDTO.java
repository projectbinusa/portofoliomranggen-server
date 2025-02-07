package com.ticket_server.ticket.DTO;

public class ProdukDTO {
    private Long id;
    private String nama;
    private double harga;
    private String deskripsi;
    private String fotoUrl;
    private String kondisi; // Baru atau Bekas

    // Getters and Setters
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
