package com.ticket_server.ticket.DTO;

public class SiswaDTO {
    private Long id;
    private String nama;
    private String nisn;
    private String alamat;
    private String namaOrangtua;
    private String nomerHpOrangtua;
    private String nomerHp;
    private String ttl;

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