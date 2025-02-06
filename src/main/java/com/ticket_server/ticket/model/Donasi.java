package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "donasi")
public class Donasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_donasi", nullable = false)
    private String namaDonasi;

    @Column(name = "nama_donatur", nullable = false)
    private String namaDonatur;

    @Column(name = "jumlah_donasi", nullable = false)
    private Double jumlahDonasi;

    @Column(name = "ttd", nullable = false)
    private String ttd;

    public Donasi() {
    }

    public Donasi(Long id, String namaDonasi, String namaDonatur, Double jumlahDonasi, String ttd) {
        this.id = id;
        this.namaDonasi = namaDonasi;
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.ttd = ttd;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaDonasi() { return namaDonasi; }
    public void setNamaDonasi(String namaDonasi) { this.namaDonasi = namaDonasi; }

    public String getNamaDonatur() { return namaDonatur; }
    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }

    public Double getJumlahDonasi() { return jumlahDonasi; }
    public void setJumlahDonasi(Double jumlahDonasi) { this.jumlahDonasi = jumlahDonasi; }

    public String getTtd() { return ttd; }
    public void setTtd(String ttd) { this.ttd = ttd; }
}
