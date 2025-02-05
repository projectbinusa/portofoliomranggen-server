package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Organisasi;

public class OrganisasiDTO {
    private Long id;
    private String namaOrganisasi;
    private String lokasi;
    private String email;
    private String telepon;

    public OrganisasiDTO() {}

    public OrganisasiDTO(Organisasi organisasi) {
        this.id = organisasi.getId();
        this.namaOrganisasi = organisasi.getNamaOrganisasi();
        this.lokasi = organisasi.getLokasi();
        this.email = organisasi.getEmail();
        this.telepon = organisasi.getTelepon();
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
