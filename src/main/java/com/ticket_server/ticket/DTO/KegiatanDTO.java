package com.ticket_server.ticket.DTO;


public class KegiatanDTO {
    private Long id;
    private String nama;
    private String deskripsi;
    private String tingkat;
    private String penyelenggara;
    private String penanggungJawab;
    private String hasil;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getTingkat() { return tingkat; }
    public void setTingkat(String tingkat) { this.tingkat = tingkat; }

    public String getPenyelenggara() { return penyelenggara; }
    public void setPenyelenggara(String penyelenggara) { this.penyelenggara = penyelenggara; }

    public String getPenanggungJawab() { return penanggungJawab; }
    public void setPenanggungJawab(String penanggungJawab) { this.penanggungJawab = penanggungJawab; }

    public String getHasil() { return hasil; }
    public void setHasil(String hasil) { this.hasil = hasil; }
}
