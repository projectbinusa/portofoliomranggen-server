package com.ticket_server.ticket.DTO;

public class BeritaDTO {
    private Long id;
    private String nama;
    private String penulis;
    private String deskripsi;
    private String fotoUrl;
    private String tanggalTerbit;
    private String action;

    // Getters and Setters
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
}
