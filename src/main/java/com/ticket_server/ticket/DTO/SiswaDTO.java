package com.ticket_server.ticket.DTO;

import javax.validation.constraints.NotBlank;

public class SiswaDTO {
    private Long id;
    private String nama;
    private Long nisn; // Ubah dari String ke Long
    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat; // Ganti alamat dengan alamat
    private String namaOrangtua;
    private Long nomerHpOrangtua; // Ubah dari String ke Long
    private Long nomerHp; // Ubah dari String ke Long
    private String tanggalLahir; // Ganti ttl dengan tanggalLahir

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