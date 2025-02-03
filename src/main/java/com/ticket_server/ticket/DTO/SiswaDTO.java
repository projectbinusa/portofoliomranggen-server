package com.ticket_server.ticket.DTO;

public class SiswaDTO {
    private Long id;
    private String nama;
    private Long nisn;
    private String tempatTinggal;
    private String namaOrangtua;
    private Long nomerHpOrangtua;
    private Long nomerHp;
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