package com.ticket_server.ticket.DTO;

public class KelasDTO {
    private Long id;
    private String namaKelas;

    public KelasDTO() {}

    public KelasDTO(Long id, String namaKelas) {
        this.id = id;
        this.namaKelas = namaKelas;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
