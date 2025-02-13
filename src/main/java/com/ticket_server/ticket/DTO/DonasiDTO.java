package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Donasi;

public class DonasiDTO {
    private Long id;
    private Long idAdmin;
    private String namaDonasi;
    private String namaDonatur;
    private double jumlahDonasi;
    private String fotoUrl;
    private String deskripsi;

    public DonasiDTO() {}

    public DonasiDTO(Donasi donasi) {
        this.id = donasi.getId();
        this.idAdmin = donasi.getAdmin().getId(); // Menyesuaikan dengan model Donasi
        this.namaDonasi = donasi.getNamaDonasi();
        this.namaDonatur = donasi.getNamaDonatur();
        this.jumlahDonasi = donasi.getJumlahDonasi();
        this.fotoUrl = donasi.getFotoUrl();
        this.deskripsi = donasi.getDeskripsi();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Long idAdmin) { this.idAdmin = idAdmin; }

    public String getNamaDonasi() { return namaDonasi; }
    public void setNamaDonasi(String namaDonasi) { this.namaDonasi = namaDonasi; }

    public String getNamaDonatur() { return namaDonatur; }
    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }

    public double getJumlahDonasi() { return jumlahDonasi; }
    public void setJumlahDonasi(double jumlahDonasi) { this.jumlahDonasi = jumlahDonasi; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}
