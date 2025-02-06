package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Guru;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDTO {
    private Long id;
    private Long idAdmin;
    private String namaGuru;
    private String nip;
    private String alamat;
    private String nomerHp;
    private Long tahunDiterima;  // Changed to Long
    private Long lamaKerja;  // Changed to Long

    // Constructor for converting Guru entity to DTO
    public GuruDTO(Guru guru) {
        this.id = guru.getId();
        this.idAdmin = guru.getAdmin().getId();
        this.namaGuru = guru.getNamaGuru();
        this.nip = guru.getNip();
        this.alamat = guru.getAlamat();
        this.nomerHp = guru.getNomerHp();
        this.tahunDiterima = Long.valueOf(guru.getTahunDiterima());
        this.lamaKerja = Long.valueOf(guru.getLamaKerja());
    }
}
