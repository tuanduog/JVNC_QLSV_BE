package com.edu.student_management_backend.controller;

import com.edu.student_management_backend.model.Admin;
import com.edu.student_management_backend.model.AuthRequest;
import com.edu.student_management_backend.model.AuthResponse;
import com.edu.student_management_backend.service.AuthService;

import com.edu.student_management_backend.util.JwtUtil;

import jakarta.transaction.Transactional;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.edu.student_management_backend.repository.*;
import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.model.GiangVien;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://api.student-management.io.vn")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private GiangVienRepo giangVienRepo;

    @Autowired
    private AdminRepo adminRepo;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Ánh xạ thông tin từ fe và lưu và object AuthRequest
        try {
            // Xác thực mã sinh viên và mật khẩu
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getTendn(), 
                            authRequest.getMatkhau()
                    )
            );

            // Load thông tin người dùng từ DB
            UserDetails authDetails = authService.loadUserByUsername(authRequest.getTendn());
            
            // Tạo token JWT
            String token = jwtUtil.generateToken(authDetails, authRequest.isRemember());
            String role = authDetails.getAuthorities().stream()
                .findFirst()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .orElse("UNKNOWN");

            // Trả về token cho frontend
            return ResponseEntity.ok(new AuthResponse(token, role));

        } catch (AuthenticationException e) {
            e.printStackTrace(); // xem rõ lỗi gì
            return ResponseEntity.status(401).body("Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    @PostMapping("/logout")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }

    @GetMapping("/user-info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String tokenHeader){
        //SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = tokenHeader.substring(7);
        String tendn = jwtUtil.extractUsername(token);

        SinhVien sv = sinhVienRepo.findByMasv(tendn).orElse(null);
        if(sv != null){
            return ResponseEntity.ok(sv);
        }
        GiangVien gv = giangVienRepo.findByMagv(tendn).orElse(null);
        if(gv != null){
            return ResponseEntity.ok(gv);
        }
        Admin admin = adminRepo.findByMaqt(tendn).orElse(null);
        if(admin != null){
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.status(404).body("Không tìm thấy người dùng");
    }

}
