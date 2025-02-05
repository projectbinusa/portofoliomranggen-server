package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "kegiatan")
public class Kegiatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @Column(name = "tingkat", nullable = false)
    private String tingkat;

    @Column(name = "penyelenggara", nullable = false)
    private String penyelenggara;

    @Column(name = "penanggung_jawab", nullable = false)
    private String penanggungJawab;

    @Column(name = "hasil", nullable = false)
    private String hasil;

    public Kegiatan() {
    }

    public Kegiatan(Long id, String nama, String deskripsi, String tingkat, String penyelenggara, String penanggungJawab, String hasil) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tingkat = tingkat;
        this.penyelenggara = penyelenggara;
        this.penanggungJawab = penanggungJawab;
        this.hasil = hasil;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getTingkat() { return tingkat; }
    public void setTingkat(String tingkat) { this.tingkat = tingkat; }

    public String getPenyelenggara() { return penyelenggara; }
    public void setPenyelenggara(String penyelenggara) { this.penyelenggara = penyelenggara; }

    public String getPenanggungJawab() { return penanggungJawab; }
    public void setPenanggungJawab(String penanggungJawab) { this.penanggungJawab = penanggungJawab; }

    public String getHasil() { return hasil; }
    public void setHasil(String hasil) { this.hasil = hasil; }
}
