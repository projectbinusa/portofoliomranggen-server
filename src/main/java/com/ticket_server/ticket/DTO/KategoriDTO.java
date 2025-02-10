package com.ticket_server.ticket.DTO;

public class KategoriDTO {
    private Long id;
    private String namaKategori;

    public KategoriDTO() {}

    public KategoriDTO(Long id, String namaKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamakategori(String namakategori) {
        this.namaKategori = namaKategori;
    }
}
