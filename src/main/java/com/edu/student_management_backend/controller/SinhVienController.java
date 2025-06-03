package com.edu.student_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.student_management_backend.model.PhanHoi;
import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.model.ThoiKhoaBieu;
import com.edu.student_management_backend.service.PhanHoiService;
import com.edu.student_management_backend.service.SinhVienService;
import com.edu.student_management_backend.service.ThoiKhoaBieuService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private PhanHoiService phanHoiService;

    @Autowired
    private ThoiKhoaBieuService thoiKhoaBieuService;

    @PutMapping("/update-sinhvien/{id}")
    public ResponseEntity<?> updateSinhVien(@PathVariable String id, @RequestBody SinhVien sinhVien) {
        //TODO: process PUT request
        SinhVien sv_update = sinhVienService.updateSinhVien(id, sinhVien);
        return ResponseEntity.ok(sv_update);
    }

    @PostMapping("/add-phanhoi")
    public ResponseEntity<?> postMethodName(@RequestBody PhanHoi phanHoi) {
        phanHoi.setTrangthai("Chưa duyệt");
        PhanHoi ph = phanHoiService.addPhanHoi(phanHoi);
        return ResponseEntity.ok(ph);
    }

    @GetMapping("/getAll-thoikhoabieu/{masv}")
    public ResponseEntity<?> getAlltkb(@PathVariable String masv) {
        List<ThoiKhoaBieu> tkb = thoiKhoaBieuService.getAlltkb(masv);
        if(tkb.isEmpty()){
            return ResponseEntity.badRequest().body("Sinh viên này không có học phần nào");
        }
        return ResponseEntity.ok(tkb);
    }
    
    
}
