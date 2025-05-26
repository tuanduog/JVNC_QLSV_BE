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
import com.edu.student_management_backend.repository.HocPhanRepo;
import com.edu.student_management_backend.repository.PhanHoiRepo;
import com.edu.student_management_backend.service.HocPhanService;
import com.edu.student_management_backend.service.PhanHoiService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
    @Autowired
    private PhanHoiService phanHoiService;

    @Autowired
    private PhanHoiRepo phanHoiRepo;

    @Autowired
    private HocPhanRepo hocPhanRepo;

    @Autowired
    private HocPhanService hocPhanService;

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
    
}
