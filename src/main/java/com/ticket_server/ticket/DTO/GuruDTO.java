package com.ticket_server.ticket.DTO;

public class GuruDTO {
    private Long id;
    private Long idAdmin;
    private String namaGuru;
    private String nip;
    private String alamat;
    private String nomerHp;
    private Integer tahunDiterima;
    private Integer lamaKerja;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(String nomerHp) {
        this.nomerHp = nomerHp;
    }

    public Integer getTahunDiterima() {
        return tahunDiterima;
    }

    public void setTahunDiterima(Integer tahunDiterima) {
        this.tahunDiterima = tahunDiterima;
    }

    public Integer getLamaKerja() {
        return lamaKerja;
    }

    public void setLamaKerja(Integer lamaKerja) {
        this.lamaKerja = lamaKerja;
    }
}
