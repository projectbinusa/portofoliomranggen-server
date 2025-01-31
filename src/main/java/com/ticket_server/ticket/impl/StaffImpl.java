package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.StaffDTO;
import com.ticket_server.ticket.exception.NotFoundException;
import com.ticket_server.ticket.model.Staff;
import com.ticket_server.ticket.repository.StaffRepository;
import com.ticket_server.ticket.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StaffImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public StaffDTO tambahStaff(StaffDTO staffDTO) {
        return null;
    }

    @Override
    public StaffDTO editStaff(Long id, StaffDTO staffDTO) throws IOException {
        return null;
    }

    @Override
    public StaffDTO editStaff(Long id, String staffJson, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public StaffDTO tambahStaffDTO(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setNama(staffDTO.getNama());
        staff.setAlamat(staffDTO.getAlamat());
        staff.setNoTelepon(staffDTO.getnoTelepon());
        staff.setAwalBekerja(staffDTO.getAwalBekerja());
        staff.setLamaKerja(staffDTO.getAwalBekerja());
        staff.setCreateDate(staffDTO.getCreateDate());

        Staff savedStaff = staffRepository.save(staff);

        StaffDTO result = new StaffDTO();
        result.setId(savedStaff.getId());
        result.setNama(savedStaff.getNama());
        result.setAlamat(savedStaff.getAlamat());
        result.setnoTelepon(savedStaff.getNoTelepon());
        result.setAwalBekerja(savedStaff.getAwalBekerja());
        result.setLamaKerja(savedStaff.getLamaKerja());
        result.setCreateDate(savedStaff.getCreateDate());

        return result;
    }

    @Override
    public StaffDTO editStaffDTO(Long id, StaffDTO staffDTO) {
        Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Staff with ID " + id + " not found"));

        existingStaff.setNama(staffDTO.getNama());
        existingStaff.setAlamat(staffDTO.getAlamat());
        existingStaff.setNoTelepon(staffDTO.getnoTelepon());
        existingStaff.setAwalBekerja(staffDTO.getAwalBekerja());
        existingStaff.setLamaKerja(staffDTO.getAwalBekerja());
        existingStaff.setCreateDate(staffDTO.getCreateDate());

        Staff updatedStaff = staffRepository.save(existingStaff);

        StaffDTO result = new StaffDTO();
        result.setId(updatedStaff.getId());
        result.setNama(updatedStaff.getNama());
        result.setAlamat(updatedStaff.getAlamat());
        result.setnoTelepon(updatedStaff.getNoTelepon());
        result.setAwalBekerja(updatedStaff.getAwalBekerja());
        result.setLamaKerja(updatedStaff.getLamaKerja());
        result.setCreateDate(updatedStaff.getCreateDate());

        return result;
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    // Helper method untuk menghitung lama kerja
    private int calculateLamaKerja(LocalDate awalBekerja) {
        return LocalDate.now().getYear() - awalBekerja.getYear();
    }
}
