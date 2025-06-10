package com.edu.student_management_backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.student_management_backend.model.GiangVien;
import com.edu.student_management_backend.model.HocPhan;
import com.edu.student_management_backend.model.PhanHoi;
import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.repository.PhanHoiRepo;
import com.edu.student_management_backend.service.GiangVienService;
import com.edu.student_management_backend.service.HocPhanService;
import com.edu.student_management_backend.service.PhanHoiService;
import com.edu.student_management_backend.service.SinhVienService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://api.student-management.io.vn")
public class AdminController {
    @Autowired
    private PhanHoiService phanHoiService;

    @Autowired
    private PhanHoiRepo phanHoiRepo;

    @Autowired
    private HocPhanService hocPhanService;

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("/getall-sinhvien")
    public ResponseEntity<?> getMethodName() {
        List<SinhVien> sv = sinhVienService.getAllSinhVien();
        return ResponseEntity.ok(sv);
    }
    
    @PostMapping("/delete-sinhvien/{masv}")
    public ResponseEntity<?> deleteSinhVien(@PathVariable String masv) {
        boolean res = sinhVienService.deleteSinhVien(masv);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/add-sinhvien")
    public ResponseEntity<?> addSinhVien(@RequestBody SinhVien sv) {
        SinhVien sv_new = sinhVienService.addSinhVien(sv);
        if(sv_new != null){
            return ResponseEntity.ok(sv_new);
        }
        return ResponseEntity.badRequest().body("Sinh viên này đã tồn tại");
    }
    
    @PostMapping("/adm-update-sv/{masv}")
    public ResponseEntity<?> adUpdateSinhVien(@PathVariable String masv, @RequestBody SinhVien sv_new) {
        SinhVien sv = sinhVienService.adUpdateSinhVien(masv, sv_new);
        return ResponseEntity.ok(sv);
    }

    @GetMapping("/getall-giangvien")
    public ResponseEntity<?> getAllgv() {
        List<GiangVien> gv = giangVienService.getAllGiangVien();
        return ResponseEntity.ok(gv);
    }

    @PostMapping("/delete-giangvien/{magv}")
    public ResponseEntity<?> deleteGiangVien(@PathVariable String magv) {
        boolean res = giangVienService.deleteGiangVien(magv);
        return ResponseEntity.ok(res);
    }
    
    @PostMapping("/add-giangvien")
    public ResponseEntity<?> addGiangVien(@RequestBody GiangVien gv) {
        GiangVien gv_new = giangVienService.addGiangVien(gv);
        if(gv_new != null){
            return ResponseEntity.ok(gv_new);
        }
        return ResponseEntity.badRequest().body("Giảng viên này đã tồn tại");
    }
    
    @PostMapping("/adm-update-gv/{magv}")
    public ResponseEntity<?> putMethodName(@PathVariable String magv, @RequestBody GiangVien gv) {
        GiangVien gv_new = giangVienService.adUpdateGiangVien(magv, gv);
        return ResponseEntity.ok(gv_new);
    }

    @GetMapping("/get-phanhoi")
    public ResponseEntity<?> getPhanhoi() {
        List<PhanHoi> res = phanHoiService.getAllPhanHoi();
        return ResponseEntity.ok(res);
    }

    @PutMapping("/check-phanhoi/{maph}")
    public ResponseEntity<?> updateTrangthai(@PathVariable int maph, @RequestBody Map<String, String> trangthai) {
        Optional<PhanHoi> optionalPhanHoi = phanHoiRepo.findByMaph(maph);

        if(optionalPhanHoi.isPresent()){
            PhanHoi ph = optionalPhanHoi.get();
            String newtt = trangthai.get("trangthai");
            ph.setTrangthai(newtt);
            phanHoiRepo.save(ph);
            return ResponseEntity.ok(ph);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PostMapping("/delete-phanhoi/{maph}")
    public ResponseEntity<?> deletePhanhoi(@PathVariable int maph) {
        boolean res = phanHoiService.deletePhanhoi(maph);
        if(res){
            return ResponseEntity.ok("Xoá thành công");
        }
        return ResponseEntity.badRequest().body("Xóa thất bại");
    }
    
    @GetMapping("/getall-hocphan")
    public ResponseEntity<?> getAllHocphan() {
        List<HocPhan> hp = hocPhanService.getAllHocphan();
        return ResponseEntity.ok(hp);
    }
    
    @Transactional
    @PostMapping("/delete-hocphan/{mahp}")
    public ResponseEntity<?> deleteHocphan(@PathVariable String mahp) {
        boolean res = hocPhanService.deleteHocphan(mahp);
        if(res){
            return ResponseEntity.ok("Xoá thành công");
        }
        return ResponseEntity.badRequest().body("Xóa thất bại");
    }

    @PostMapping("/add-hocphan")
    public ResponseEntity<?> addHocphan(@RequestBody HocPhan hp) {
        HocPhan hp_new = hocPhanService.addHocPhan(hp);
        if(hp_new != null){
            return ResponseEntity.ok(hp_new);
        }
        return ResponseEntity.badRequest().body("Học phần này đã tồn tại");
    }

    @PostMapping("/adm-update-hp/{mahp}")
    public ResponseEntity<?> adUpdateHocPhan(@PathVariable String mahp, @RequestBody HocPhan hp) {
        HocPhan hp_new = hocPhanService.adUpdateHocPhan(mahp, hp);
        return ResponseEntity.ok(hp_new);
    }
    
    
}
