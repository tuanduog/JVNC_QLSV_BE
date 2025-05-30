package com.edu.student_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.student_management_backend.model.GiangVien;
import com.edu.student_management_backend.service.GiangVienService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class GiangVienController {
    @Autowired
    private GiangVienService giangVienService;

    @PutMapping("/update-giangvien/{id}")
    public ResponseEntity<?> updateGiangVien(@PathVariable String id, @RequestBody GiangVien giangVien) {
        //TODO: process PUT request
        GiangVien gv_update = giangVienService.updateGiangVien(id, giangVien);
        return ResponseEntity.ok(gv_update);
    }
}
