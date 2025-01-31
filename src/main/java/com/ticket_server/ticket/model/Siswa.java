package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "nisn", unique = true, nullable = false)
    private String nisn;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "nama_orangtua", nullable = false)
    private String namaOrangtua;

    @Column(name = "nomer_hp_orangtua", nullable = false)
    private String nomerHpOrangtua;

    @Column(name = "nomer_hp", nullable = false)
    private String nomerHp;

    @Column(name = "ttl", nullable = false)
    private String ttl; // Tempat Tanggal Lahir

    // Constructors
    public Siswa() {}

    public Siswa(Long id, String nama, String nisn, String alamat, String namaOrangtua, String nomerHpOrangtua, String nomerHp, String ttl) {
        this.id = id;
        this.nama = nama;
        this.nisn = nisn;
        this.alamat = alamat;
        this.namaOrangtua = namaOrangtua;
        this.nomerHpOrangtua = nomerHpOrangtua;
        this.nomerHp = nomerHp;
        this.ttl = ttl;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaOrangtua() {
        return namaOrangtua;
    }

    public void setNamaOrangtua(String namaOrangtua) {
        this.namaOrangtua = namaOrangtua;
    }

    public String getNomerHpOrangtua() {
        return nomerHpOrangtua;
    }

    public void setNomerHpOrangtua(String nomerHpOrangtua) {
        this.nomerHpOrangtua = nomerHpOrangtua;
    }

    public String getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(String nomerHp) {
        this.nomerHp = nomerHp;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}