package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.SiswaDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Siswa;
import com.ticket_server.ticket.repository.SiswaRepository;
import com.ticket_server.ticket.service.SiswaService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SiswaImpl implements SiswaService {
    private final SiswaRepository siswaRepository;

    public SiswaImpl(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Override
    public List<Siswa> getAllSiswa() {
        return siswaRepository.findAll();
    }

    @Override
    public Optional<Siswa> getSiswaById(Long id) {
        return siswaRepository.findById(id);
    }

    @Override
    public SiswaDTO tambahSiswaDTO(SiswaDTO siswaDTO) {
        Siswa siswa = new Siswa();
        siswa.setNama(siswaDTO.getNama());
        siswa.setNisn(siswaDTO.getNisn());
        siswa.setTempatTinggal(siswaDTO.getTempatTinggal());
        siswa.setNamaOrangtua(siswaDTO.getNamaOrangtua());
        siswa.setNomerHpOrangtua(siswaDTO.getNomerHpOrangtua());
        siswa.setNomerHp(siswaDTO.getNomerHp());
        siswa.setTanggalLahir(siswaDTO.getTanggalLahir());

        Siswa savedSiswa = siswaRepository.save(siswa);

        SiswaDTO result = new SiswaDTO();
        result.setId(savedSiswa.getId());
        result.setNama(savedSiswa.getNama());
        result.setNisn(savedSiswa.getNisn());
        result.setTempatTinggal(savedSiswa.getTempatTinggal());
        result.setNamaOrangtua(savedSiswa.getNamaOrangtua());
        result.setNomerHpOrangtua(savedSiswa.getNomerHpOrangtua());
        result.setNomerHp(savedSiswa.getNomerHp());
        result.setTanggalLahir(savedSiswa.getTanggalLahir());

        return result;
    }

    @Override
    public SiswaDTO editSiswaDTO(Long id, SiswaDTO siswaDTO) throws IOException {
        Siswa existingSiswa = siswaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Siswa tidak ditemukan"));

        existingSiswa.setNama(siswaDTO.getNama());
        existingSiswa.setNisn(siswaDTO.getNisn());
        existingSiswa.setTempatTinggal(siswaDTO.getTempatTinggal());
        existingSiswa.setNamaOrangtua(siswaDTO.getNamaOrangtua());
        existingSiswa.setNomerHpOrangtua(siswaDTO.getNomerHpOrangtua());
        existingSiswa.setNomerHp(siswaDTO.getNomerHp());
        existingSiswa.setTanggalLahir(siswaDTO.getTanggalLahir());

        Siswa updatedSiswa = siswaRepository.save(existingSiswa);

        SiswaDTO result = new SiswaDTO();
        result.setId(updatedSiswa.getId());
        result.setNama(updatedSiswa.getNama());
        result.setNisn(updatedSiswa.getNisn());
        result.setTempatTinggal(updatedSiswa.getTempatTinggal());
        result.setNamaOrangtua(updatedSiswa.getNamaOrangtua());
        result.setNomerHpOrangtua(updatedSiswa.getNomerHpOrangtua());
        result.setNomerHp(updatedSiswa.getNomerHp());
        result.setTanggalLahir(updatedSiswa.getTanggalLahir());

        return result;
    }

    @Override
    public void deleteSiswa(Long id) throws IOException {
        if (!siswaRepository.existsById(id)) {
            throw new NotFoundException("Siswa tidak ditemukan");
        }
        siswaRepository.deleteById(id);
    }
}