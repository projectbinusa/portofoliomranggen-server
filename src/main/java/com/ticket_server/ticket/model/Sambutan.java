package com.ticket_server.ticket.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sambutan")
public class Sambutan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Column(name = "deskripsi", nullable = false)  // Ganti 'konten' dengan 'deskripsi'
    private String deskripsi;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    public Sambutan() {}

    public Sambutan(Long id, String judul, String deskripsi, LocalDateTime createDate) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.createDate = createDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }  // Ganti 'konten' dengan 'deskripsi'
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public LocalDateTime getCreateDate() { return createDate; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
}
