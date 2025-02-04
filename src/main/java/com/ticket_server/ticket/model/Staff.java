package com.ticket_server.ticket.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "no_telepon", nullable = false)
    private String noTelepon;

    @Column(name = "awal_bekerja", nullable = false)
    private  String awalBekerja;

    @Column(name = "lama_kerja", nullable = false)
    private String lamaKerja;

    @Column(name = "create_Date", nullable = false)
    private LocalDate createDate;

    public Staff() {
    }

    public Staff(Long id, String nama, String alamat, String noTelepon, String awalBekerja, String lamaKerja, LocalDate createDate) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.awalBekerja = awalBekerja;
        this.lamaKerja = lamaKerja;
        this.createDate = createDate;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNama() {return nama;}

    public void setNama(String nama) {this.nama = nama;}

    public String getAlamat() {return alamat;}

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public String getNoTelepon() {return noTelepon;}

    public void setNoTelepon(String noTelepon) {this.noTelepon = noTelepon;}

    public String getAwalBekerja() {
        return awalBekerja;}
    public void setAwalBekerja(String awalBekerja) {this.awalBekerja = awalBekerja;}

    public String getLamaKerja() {return lamaKerja;}

    public void setLamaKerja(String lamaKerja) {this.lamaKerja = lamaKerja;}

    public LocalDate getCreateDate() {return createDate;}

    public void setCreateDate(LocalDate createDate) {this.createDate = createDate;}
}