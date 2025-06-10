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
import com.edu.student_management_backend.model.Lop;
import com.edu.student_management_backend.model.PhanHoi;
import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.model.ThoiKhoaBieu;
import com.edu.student_management_backend.service.DiemHocPhanService;
import com.edu.student_management_backend.service.LopService;
import com.edu.student_management_backend.service.PhanHoiService;
import com.edu.student_management_backend.service.SinhVienService;
import com.edu.student_management_backend.service.ThoiKhoaBieuService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://api.student-management.io.vn")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private PhanHoiService phanHoiService;

    @Autowired
    private ThoiKhoaBieuService thoiKhoaBieuService;

    @Autowired DiemHocPhanService diemHocPhanService;
    @Autowired
    private LopService lopService;

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
    
    @GetMapping("/getAll-diemhocphan/{masv}")
    public ResponseEntity<?> getAllDiemHP(@PathVariable String masv) {
        List<DiemHocPhan> dhp = diemHocPhanService.getAllDiemHocPhan(masv);
        if(dhp.isEmpty()){
            return ResponseEntity.badRequest().body("Chưa có điểm học phần");
        }
        return ResponseEntity.ok(dhp);
    }
    
    @GetMapping("/get1SinhVien/{masv}")
    public ResponseEntity<?> get1SinhVien(@PathVariable String masv) {
        SinhVien sv = sinhVienService.get1SinhVien(masv);
        if(sv == null){
            return ResponseEntity.badRequest().body("Khong tim thay sv nao");
        }
        return ResponseEntity.ok(sv);
    }

    @GetMapping("/getlopinfo/{malop}")
    public ResponseEntity<?> getLopInfo(@PathVariable String malop) {
        Lop lp = lopService.getLopInfo(malop);
        if(lp == null){
            return ResponseEntity.badRequest().body("Ko tim thay lop");
        }
        return ResponseEntity.ok(lp);
    }
    
    
}
