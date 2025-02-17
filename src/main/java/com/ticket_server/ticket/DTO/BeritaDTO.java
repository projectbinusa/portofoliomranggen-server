package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Berita;
import java.time.LocalDate;

public class BeritaDTO {
    private Long id;
    private String nama;
    private String penulis;
    private String deskripsi;
    private LocalDate tanggalTerbit;
    private String fotoUrl;
    private Long idAdmin;

    public BeritaDTO() {}

    public BeritaDTO(Berita berita) {
        this.id = berita.getId();
        this.nama = berita.getNama();
        this.penulis = berita.getPenulis();
        this.deskripsi = berita.getDeskripsi();
        this.tanggalTerbit = berita.getTanggalTerbit();
        this.fotoUrl = berita.getFotoUrl();
        this.idAdmin = berita.getIdAdmin();
    }

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
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public Long getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Long idAdmin) { this.idAdmin = idAdmin; }
}