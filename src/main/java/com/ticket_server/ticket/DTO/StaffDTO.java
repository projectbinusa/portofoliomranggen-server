package com.ticket_server.ticket.DTO;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class StaffDTO {
    private Long id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private String awalBekerja;
    private String lamaKerja;
    private LocalDateTime createDate;

    @PrePersist
    public void onPrePersist() {
        createDate = LocalDateTime.now();
    }
//    private String fotoUrl;

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getnoTelepon() {
        return noTelepon;
    }

    public void setnoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAwalBekerja() {
        return awalBekerja;
    }

    public void setAwalBekerja(String AwalBekerja) {
        this.awalBekerja = AwalBekerja;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLamaKerja() {
        return lamaKerja;
    }

    public void setLamaKerja(String lamaKerja) {
        this.lamaKerja = lamaKerja;
    }

//    public String getFotoUrl() {
//        return fotoUrl;
//    }
//
//    public void setFotoUrl(String fotoUrl) {
//        this.fotoUrl = fotoUrl;
//    }
}
