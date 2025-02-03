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
    private Long nisn; // Ubah dari String ke Long

    @Column(name = "tempat_tinggal", nullable = false) // Ganti alamat dengan tempat_tinggal
    private String tempatTinggal;

    @Column(name = "nama_orangtua", nullable = false)
    private String namaOrangtua;

    @Column(name = "nomer_hp_orangtua", nullable = false)
    private Long nomerHpOrangtua; // Ubah dari String ke Long

    @Column(name = "nomer_hp", nullable = false)
    private Long nomerHp; // Ubah dari String ke Long

    @Column(name = "tanggal_lahir", nullable = false) // Ganti ttl dengan tanggal_lahir
    private String tanggalLahir;

    // Constructors
    public Siswa() {}

    public Siswa(Long id, String nama, Long nisn, String tempatTinggal, String namaOrangtua, Long nomerHpOrangtua, Long nomerHp, String tanggalLahir) {
        this.id = id;
        this.nama = nama;
        this.nisn = nisn;
        this.tempatTinggal = tempatTinggal;
        this.namaOrangtua = namaOrangtua;
        this.nomerHpOrangtua = nomerHpOrangtua;
        this.nomerHp = nomerHp;
        this.tanggalLahir = tanggalLahir;
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