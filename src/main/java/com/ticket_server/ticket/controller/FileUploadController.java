package com.ticket_server.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class FileUploadController {

    private final String uploadDir = "uploads/";

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Cek apakah file kosong
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File tidak boleh kosong");
            }

            // Membuat nama file unik
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // Menentukan path penyimpanan
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Path filePath = uploadPath.resolve(fileName);

            // Buat folder jika belum ada
            Files.createDirectories(uploadPath);

            // Simpan file ke sistem
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // URL akses gambar
            String imageUrl = "http://localhost:4321/uploads/" + fileName;

            // Kembalikan URL gambar yang dapat diakses
            return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal mengunggah gambar: " + e.getMessage());
        }
    }
}
