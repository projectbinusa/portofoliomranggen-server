package com.ticket_server.ticket.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kegiatan")
public class Kegiatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_kegiatan", nullable = false)
    private String namaKegiatan;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @Column(name = "penanggung_jawab", nullable = false)
    private String penanggungJawab;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    public Kegiatan() {
    }

    public Kegiatan(Long id, String namaKegiatan, String deskripsi, String penanggungJawab, LocalDateTime createDate) {
        this.id = id;
        this.namaKegiatan = namaKegiatan;
        this.deskripsi = deskripsi;
        this.penanggungJawab = penanggungJawab;
        this.createDate = createDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaKegiatan() { return namaKegiatan; }
    public void setNamaKegiatan(String namaKegiatan) { this.namaKegiatan = namaKegiatan; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getPenanggungJawab() { return penanggungJawab; }
    public void setPenanggungJawab(String penanggungJawab) { this.penanggungJawab = penanggungJawab; }

    public LocalDateTime getCreateDate() { return createDate; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
}
