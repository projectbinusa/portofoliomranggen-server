package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "visi_misi")
public class VisiMisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visi", nullable = false)
    private String visi;

    @Column(name = "misi", nullable = false)
    private String misi;

    @Column(name = "admin_id", nullable = false)
    private Long adminId;  // ID of the admin who created or updated the entry

    public VisiMisi() {}

    public VisiMisi(Long id, String visi, String misi, Long adminId) {
        this.id = id;
        this.visi = visi;
        this.misi = misi;
        this.adminId = adminId;
    }

    // Getter and Setter methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVisi() { return visi; }
    public void setVisi(String visi) { this.visi = visi; }

    public String getMisi() { return misi; }
    public void setMisi(String misi) { this.misi = misi; }

    public Long getAdminId() { return adminId; }
    public void setAdminId(Long adminId) { this.adminId = adminId; }
}
