package com.edu.student_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.service.SinhVienService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @PutMapping("/update-sinhvien/{id}")
    public ResponseEntity<?> updateSinhVien(@PathVariable String id, @RequestBody SinhVien sinhVien) {
        //TODO: process PUT request
        SinhVien sv_update = sinhVienService.updateSinhVien(id, sinhVien);
        return ResponseEntity.ok(sv_update);
    }
}
