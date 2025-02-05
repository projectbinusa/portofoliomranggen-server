package com.ticket_server.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "buku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul_buku", nullable = false)
    private String judulBuku;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "penerbit")
    private String penerbit;

    @Column(name = "pengarang")
    private String pengarang;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;

    @Column(name = "jumlah_halaman")
    private Integer jumlahHalaman;

    @Column(name = "foto_url")
    private String fotoUrl;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;
}
