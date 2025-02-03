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
    private Long nisn;

    @Column(name = "tempat_tinggal", nullable = false)
    private String tempatTinggal;

    @Column(name = "nama_orangtua", nullable = false)
    private String namaOrangtua;

    @Column(name = "nomer_hp_orangtua", nullable = false)
    private Long nomerHpOrangtua;

    @Column(name = "nomer_hp", nullable = false)
    private Long nomerHp;

    @Column(name = "tanggal_lahir", nullable = false)
    private String tanggalLahir;

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

    public Long getNisn() {
        return nisn;
    }

    public void setNisn(Long nisn) {
        this.nisn = nisn;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }

    public String getNamaOrangtua() {
        return namaOrangtua;
    }

    public void setNamaOrangtua(String namaOrangtua) {
        this.namaOrangtua = namaOrangtua;
    }

    public Long getNomerHpOrangtua() {
        return nomerHpOrangtua;
    }

    public void setNomerHpOrangtua(Long nomerHpOrangtua) {
        this.nomerHpOrangtua = nomerHpOrangtua;
    }

    public Long getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(Long nomerHp) {
        this.nomerHp = nomerHp;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}