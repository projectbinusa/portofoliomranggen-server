package com.ticket_server.ticket.DTO;

import java.time.LocalDate;

public class StaffDTO {
    private Long id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private String awalBekerja;
    private String lamaKerja;
    private LocalDate createDate;

    // Getters and Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNama() {return nama;}

    public void setNama(String nama) {this.nama = nama;}

    public String getAlamat() {return alamat;}

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public String getNoTelepon() {return noTelepon;}

    public void setNoTelepon(String noTelepon) {this.noTelepon = noTelepon;}

    public String getAwalBekerja() {return awalBekerja;}

    public void setAwalBekerja(String awalBekerja) {this.awalBekerja = awalBekerja;}

    public String getLamaKerja() {return lamaKerja;}

    public void setLamaKerja(String lamaKerja) {this.lamaKerja = lamaKerja;}

    public LocalDate getCreateDate() {return createDate;}

    public void setCreateDate(LocalDate createDate) {this.createDate = createDate;}

}