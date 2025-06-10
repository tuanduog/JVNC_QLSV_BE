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

import com.edu.student_management_backend.model.DiemHocPhan;
import com.edu.student_management_backend.model.GiangVien;
import com.edu.student_management_backend.model.HocPhan_GiangVien;
import com.edu.student_management_backend.service.GiangVienService;
import com.edu.student_management_backend.service.HocPhanPhuTrachService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://api.student-management.io.vn")
public class GiangVienController {
    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private HocPhanPhuTrachService hocPhanPhuTrachService;

    @PutMapping("/update-giangvien/{id}")
    public ResponseEntity<?> updateGiangVien(@PathVariable String id, @RequestBody GiangVien giangVien) {
        //TODO: process PUT request
        GiangVien gv_update = giangVienService.updateGiangVien(id, giangVien);
        return ResponseEntity.ok(gv_update);
    }

    @GetMapping("/getAll-hocphan/{magv}")
    public ResponseEntity<?> getAlltkb(@PathVariable String magv) {
        List<HocPhan_GiangVien> hp = hocPhanPhuTrachService.getAllHocPhan_GiangVien(magv);
        if(hp == null){
            return ResponseEntity.badRequest().body("Không có học phần nào");
        }
        return ResponseEntity.ok(hp);
    }

    @GetMapping("/get-sinhvien-in-hocphan/{mahp}")
    public ResponseEntity<?> getSVinHP(@PathVariable String mahp) {
        List<DiemHocPhan> dhp = hocPhanPhuTrachService.getAllSVInHocphan(mahp);
        if(dhp.isEmpty()){
            return ResponseEntity.badRequest().body("Không có sinh viên nào trong học phần này.");
        }
        return ResponseEntity.ok(dhp);
    }
    
    @PutMapping("/update-diem/{madhp}")
    public ResponseEntity<?> updateDiem(@PathVariable int madhp, @RequestBody DiemHocPhan diemsv) {
        DiemHocPhan dhp = hocPhanPhuTrachService.updateDiem(madhp, diemsv);
        if(dhp == null){
            return ResponseEntity.badRequest().body("Khong tim thay sinh vien nao");
        }
        return ResponseEntity.ok(dhp);
    }
}
