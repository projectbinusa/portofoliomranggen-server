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
    private double jumlahDonasi;
    private String fotoUrl;
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    public Donasi() {}

    public Donasi(Long id, Admin admin, String namaDonasi, String namaDonatur, double jumlahDonasi, String fotoUrl, String deskripsi) {
        this.id = id;
        this.admin = admin;
        this.namaDonasi = namaDonasi;
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.fotoUrl = fotoUrl;
        this.deskripsi = deskripsi;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
}