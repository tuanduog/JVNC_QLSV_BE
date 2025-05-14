package com.edu.student_management_backend.controller;

import com.edu.student_management_backend.model.AuthRequest;
import com.edu.student_management_backend.model.AuthResponse;
import com.edu.student_management_backend.service.SinhVienService;
import com.edu.student_management_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class SinhVienController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Ánh xạ thông tin từ fe và lưu và object AuthRequest
        try {
            // Xác thực mã sinh viên và mật khẩu
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getMasv(), 
                            authRequest.getMatkhau()
                    )
            );

            // Load thông tin người dùng từ DB
            UserDetails sinhVienDetails = sinhVienService.loadUserByUsername(authRequest.getMasv());

            // Tạo token JWT
            String token = jwtUtil.generateToken(sinhVienDetails);

            // Trả về token cho frontend
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Sai mã sinh viên hoặc mật khẩu");
        }
    }
}
