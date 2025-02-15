package com.ticket_server.ticket.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "berita")
public class Berita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String penulis;
    private String deskripsi;
    private LocalDate tanggalTerbit;
    private String action;
    private String fotoUrl;
    private Long idAdmin;

    public Berita() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public LocalDate getTanggalTerbit() { return tanggalTerbit; }
    public void setTanggalTerbit(LocalDate tanggalTerbit) { this.tanggalTerbit = tanggalTerbit; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public Long getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Long idAdmin) { this.idAdmin = idAdmin; }
}