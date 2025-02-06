package com.ticket_server.ticket.DTO;


public class DonasiDTO {
    private Long id;
    private String namaDonasi;
    private String namaDonatur;
    private Double jumlahDonasi;
    private String ttd;

    // Getters and Setters
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
