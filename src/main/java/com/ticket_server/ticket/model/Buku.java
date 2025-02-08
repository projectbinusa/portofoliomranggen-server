package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul_buku", nullable = false)
    private String judulBuku;

    @Column(name = "penerbit", nullable = false)
    private String penerbit;

    @Column(name = "pengarang", nullable = false)
    private String pengarang;

    @Column(name = "tahun_terbit", nullable = false)
    private int tahunTerbit;

    @Column(name = "jumlah_halaman", nullable = false)
    private int jumlahHalaman;

    @Column(name = "foto_url")
    private String fotoUrl;

    public Buku() {
    }

    public Buku(Long id, String judulBuku, String penerbit, String pengarang, int tahunTerbit, int jumlahHalaman, String fotoUrl) {
        this.id = id;
        this.judulBuku = judulBuku;
        this.penerbit = penerbit;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.jumlahHalaman = jumlahHalaman;
        this.fotoUrl = fotoUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getJudulBuku() { return judulBuku; }
    public void setJudulBuku(String judulBuku) { this.judulBuku = judulBuku; }
    public String getPenerbit() { return penerbit; }
    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }
    public String getPengarang() { return pengarang; }
    public void setPengarang(String pengarang) { this.pengarang = pengarang; }
    public int getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(int tahunTerbit) { this.tahunTerbit = tahunTerbit; }
    public int getJumlahHalaman() { return jumlahHalaman; }
    public void setJumlahHalaman(int jumlahHalaman) { this.jumlahHalaman = jumlahHalaman; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}
