package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "berita")
public class Berita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String penulis;
    private String deskripsi;
    private String fotoUrl;
    private String tanggalTerbit;
    private String action;
    private Long idAdmin;

    // 🔹 Constructor kosong (wajib untuk JPA)
    public Berita() {}

    // 🔹 Constructor untuk DTO (agar mudah konversi)
    public Berita(com.ticket_server.ticket.DTO.BeritaDTO beritaDTO) {
        this.nama = beritaDTO.getNama();
        this.penulis = beritaDTO.getPenulis();
        this.deskripsi = beritaDTO.getDeskripsi();
        this.fotoUrl = beritaDTO.getFotoUrl();
        this.tanggalTerbit = beritaDTO.getTanggalTerbit();
        this.action = beritaDTO.getAction();
        this.idAdmin = beritaDTO.getIdAdmin();
    }

    // 🔹 Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getTanggalTerbit() { return tanggalTerbit; }
    public void setTanggalTerbit(String tanggalTerbit) { this.tanggalTerbit = tanggalTerbit; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Long getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Long idAdmin) { this.idAdmin = idAdmin; }
}
