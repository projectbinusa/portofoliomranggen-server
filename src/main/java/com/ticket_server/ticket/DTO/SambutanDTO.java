package com.ticket_server.ticket.DTO;

public class SambutanDTO {
    private Long id;
    private String judul;
    private String deskripsi;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}
