package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "donasi")
public class Donasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaDonasi;
    private String namaDonatur;
    private Double jumlahDonasi;
    private String deskripsi;
    private String fotoUrl;

    public Donasi() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNamaDonasi() { return namaDonasi; }
    public void setNamaDonasi(String namaDonasi) { this.namaDonasi = namaDonasi; }
    public String getNamaDonatur() { return namaDonatur; }
    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }
    public Double getJumlahDonasi() { return jumlahDonasi; }
    public void setJumlahDonasi(Double jumlahDonasi) { this.jumlahDonasi = jumlahDonasi; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}
