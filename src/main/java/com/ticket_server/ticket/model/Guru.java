package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "guru")
public class Guru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_guru")
    private String namaGuru;

    @Column(name = "nip", unique = true)
    private Long nip; // Diubah menjadi Long

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nomer_hp")
    private Long nomerHp; // Diubah menjadi Long

    @Column(name = "tahun_diterima")
    private String tahunDiterima;

    @Column(name = "lama_kerja")
    private String lamaKerja;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(Long nomerHp) {
        this.nomerHp = nomerHp;
    }

    public String getTahunDiterima() {
        return tahunDiterima;
    }

    public void setTahunDiterima(String tahunDiterima) {
        this.tahunDiterima = tahunDiterima;
    }

    public String getLamaKerja() {
        return lamaKerja;
    }

    public void setLamaKerja(String lamaKerja) {
        this.lamaKerja = lamaKerja;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
