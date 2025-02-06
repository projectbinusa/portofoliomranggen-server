package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Admin;
import com.ticket_server.ticket.model.Guru;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDTO {
    private Long id;

    @NotNull(message = "idAdmin tidak boleh kosong")
    private Long idAdmin;

    @NotBlank(message = "Nama guru tidak boleh kosong")
    private String namaGuru;

    @NotBlank(message = "NIP tidak boleh kosong")
    private String nip;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @NotBlank(message = "Nomor HP tidak boleh kosong")
    private String nomerHp;

    @NotNull(message = "Tahun diterima tidak boleh kosong")
    private Integer tahunDiterima;

    @NotNull(message = "Lama kerja tidak boleh kosong")
    private Integer lamaKerja;

    public GuruDTO(Guru guru) {
        this.id = guru.getId();
        this.idAdmin = guru.getAdmin() != null ? guru.getAdmin().getId() : null;
        this.namaGuru = guru.getNamaGuru();
        this.nip = guru.getNip();
        this.alamat = guru.getAlamat();
        this.nomerHp = guru.getNomerHp();
        this.tahunDiterima = guru.getTahunDiterima();
        this.lamaKerja = guru.getLamaKerja();
    }

    public Guru toEntity(Admin admin) {
        Guru guru = new Guru();
        guru.setNamaGuru(this.namaGuru);
        guru.setNip(this.nip);
        guru.setAlamat(this.alamat);
        guru.setNomerHp(this.nomerHp);
        guru.setTahunDiterima(this.tahunDiterima);
        guru.setLamaKerja(this.lamaKerja);
        guru.setAdmin(admin);
        return guru;
    }
}
