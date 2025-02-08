package com.ticket_server.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "kelas")
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_kelas", nullable = false)
    private String namaKelas;

    public Kelas() {}

    public Kelas(Long id, String namaKelas) {
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
