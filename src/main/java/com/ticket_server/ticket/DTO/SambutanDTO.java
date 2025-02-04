package com.ticket_server.ticket.DTO;

import java.time.LocalDateTime;

public class SambutanDTO {
    private Long id;
    private String judul;
    private String deskripsi;  // Ganti 'konten' dengan 'deskripsi'
    private LocalDateTime createDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }  // Ganti 'konten' dengan 'deskripsi'
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public LocalDateTime getCreateDate() { return createDate; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
}
