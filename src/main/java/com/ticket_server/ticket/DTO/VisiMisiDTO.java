package com.ticket_server.ticket.DTO;

public class VisiMisiDTO {
    private Long id;
    private String visi;
    private String misi;
    private Long adminId;  // New field

    public VisiMisiDTO() {}

    public VisiMisiDTO(Long id, String visi, String misi, Long adminId) {
        this.id = id;
        this.visi = visi;
        this.misi = misi;
        this.adminId = adminId;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
