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
    private Long nip; // Diubah menjadi Long
    private String alamat;
    private Long nomerHp;  // Diubah menjadi Long
    private Long tahunDiterima;
    private Long lamaKerja;

    // Constructor untuk konversi dari entity Guru ke DTO
    public GuruDTO(Guru guru) {
        this.id = guru.getId();
        this.idAdmin = guru.getAdmin().getId();
        this.namaGuru = guru.getNamaGuru();
        this.nip = Long.valueOf(guru.getNip()); // Konversi ke Long
        this.alamat = guru.getAlamat();
        this.nomerHp = Long.valueOf(guru.getNomerHp()); // Konversi ke Long
        this.tahunDiterima = Long.valueOf(guru.getTahunDiterima());
        this.lamaKerja = Long.valueOf(guru.getLamaKerja());
    }
}
