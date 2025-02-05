package com.ticket_server.ticket.model;

import com.ticket_server.ticket.DTO.OrganisasiDTO;

import javax.persistence.*;

@Entity
@Table(name = "organisasi")
public class Organisasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_organisasi", nullable = false)
    private String namaOrganisasi;

    @Column(name = "lokasi", nullable = false)
    private String lokasi;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telepon", nullable = false)
    private String telepon;

    public Organisasi() {}

    public Organisasi(OrganisasiDTO dto) {
        this.namaOrganisasi = dto.getNamaOrganisasi();
        this.lokasi = dto.getLokasi();
        this.email = dto.getEmail();
        this.telepon = dto.getTelepon();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaOrganisasi() { return namaOrganisasi; }
    public void setNamaOrganisasi(String namaOrganisasi) { this.namaOrganisasi = namaOrganisasi; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
}
