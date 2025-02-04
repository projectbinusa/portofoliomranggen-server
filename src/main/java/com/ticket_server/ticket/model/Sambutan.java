package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "sambutan")
public class Sambutan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    public Sambutan() {}

    public Sambutan(Long id, String judul, String deskripsi) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}
