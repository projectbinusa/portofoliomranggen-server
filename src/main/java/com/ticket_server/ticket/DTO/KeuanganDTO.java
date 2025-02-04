package com.ticket_server.ticket.DTO;


public class KeuanganDTO {
    private Long id;
    private String nama;
    private double harga;
    private int jumlah;
    private double totalHarga;
    private String kategoriPembiayaan;
    private String catatan;

    // Getters and Setters
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
    // Method to calculate total price
    public void calculateTotalHarga() {
        this.totalHarga = this.harga * this.jumlah;
    }
}
