package com.ticket_server.ticket.DTO;

public class InventarisDTO {
    private Long id;
    private String nama;
    private String deskripsi;
    private int jumlah;
    private Long adminId;  // New field

    public InventarisDTO() {}

    public InventarisDTO(Long id, String nama, String deskripsi, int jumlah, Long adminId) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
        this.adminId = adminId;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
