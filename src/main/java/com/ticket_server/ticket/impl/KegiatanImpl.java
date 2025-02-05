package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.KegiatanDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Kegiatan;
import com.ticket_server.ticket.repository.KegiatanRepository;
import com.ticket_server.ticket.service.KegiatanService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KegiatanImpl implements KegiatanService {
    private final KegiatanRepository kegiatanRepository;

    public KegiatanImpl(KegiatanRepository kegiatanRepository) {
        this.kegiatanRepository = kegiatanRepository;
    }

    @Override
    public List<Kegiatan> getAllKegiatan() {
        return kegiatanRepository.findAll();
    }

    @Override
    public Optional<Kegiatan> getKegiatanById(Long id) {
        return kegiatanRepository.findById(id);
    }

    @Override
    public KegiatanDTO tambahKegiatan(KegiatanDTO kegiatanDTO) {
        return null;
    }

    @Override
    public KegiatanDTO editKegiatan(Long id, KegiatanDTO kegiatanDTO) throws IOException {
        return null;
    }

    @Override
    public KegiatanDTO editKegiatan(Long id, String kegiatanJson, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public KegiatanDTO tambahKegiatanDTO(KegiatanDTO kegiatanDTO) {
        Kegiatan kegiatan = new Kegiatan();
        kegiatan.setNama(kegiatanDTO.getNama());
        kegiatan.setDeskripsi(kegiatanDTO.getDeskripsi());
        kegiatan.setTingkat(kegiatanDTO.getTingkat());
        kegiatan.setPenyelenggara(kegiatanDTO.getPenyelenggara());
        kegiatan.setPenanggungJawab(kegiatanDTO.getPenanggungJawab());
        kegiatan.setHasil(kegiatanDTO.getHasil());

        Kegiatan savedKegiatan = kegiatanRepository.save(kegiatan);

        KegiatanDTO result = new KegiatanDTO();
        result.setId(savedKegiatan.getId());
        result.setNama(savedKegiatan.getNama());
        result.setDeskripsi(savedKegiatan.getDeskripsi());
        result.setTingkat(savedKegiatan.getTingkat());
        result.setPenyelenggara(savedKegiatan.getPenyelenggara());
        result.setPenanggungJawab(savedKegiatan.getPenanggungJawab());
        result.setHasil(savedKegiatan.getHasil());

        return result;
    }

    @Override
    public KegiatanDTO editKegiatanDTO(Long id, KegiatanDTO kegiatanDTO) {
        Kegiatan existingKegiatan = kegiatanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kegiatan tidak ditemukan"));

        existingKegiatan.setNama(kegiatanDTO.getNama());
        existingKegiatan.setDeskripsi(kegiatanDTO.getDeskripsi());
        existingKegiatan.setTingkat(kegiatanDTO.getTingkat());
        existingKegiatan.setPenyelenggara(kegiatanDTO.getPenyelenggara());
        existingKegiatan.setPenanggungJawab(kegiatanDTO.getPenanggungJawab());
        existingKegiatan.setHasil(kegiatanDTO.getHasil());

        Kegiatan updatedKegiatan = kegiatanRepository.save(existingKegiatan);

        KegiatanDTO result = new KegiatanDTO();
        result.setId(updatedKegiatan.getId());
        result.setNama(updatedKegiatan.getNama());
        result.setDeskripsi(updatedKegiatan.getDeskripsi());
        result.setTingkat(updatedKegiatan.getTingkat());
        result.setPenyelenggara(updatedKegiatan.getPenyelenggara());
        result.setPenanggungJawab(updatedKegiatan.getPenanggungJawab());
        result.setHasil(updatedKegiatan.getHasil());

        return result;
    }

    @Override
    public void deleteKegiatan(Long id) {
        if (!kegiatanRepository.existsById(id)) {
            throw new NotFoundException("Kegiatan tidak ditemukan");
        }
        kegiatanRepository.deleteById(id);
    }
}
