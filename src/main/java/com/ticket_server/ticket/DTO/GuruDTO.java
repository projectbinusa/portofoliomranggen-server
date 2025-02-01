package com.ticket_server.ticket.DTO;

public class GuruDTO {
    private Long id;
    private Long idAdmin;
    private String namaGuru;
    private Double hargaGuru;
    private String fotoUrl;

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

    public Double getHargaGuru() {
        return hargaGuru;
    }

    public void setHargaGuru(Double hargaGuru) {
        this.hargaGuru = hargaGuru;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
