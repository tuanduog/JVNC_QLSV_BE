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
@CrossOrigin(origins = "*")
public class SinhVienController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            // 1. Xác thực mã sinh viên và mật khẩu
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getMasv(), 
                            authRequest.getMatkhau()
                    )
            );

            // 2. Load thông tin người dùng từ DB
            UserDetails sinhVienDetails = sinhVienService.loadUserByUsername(authRequest.getMasv());

            // 3. Tạo token JWT
            String token = jwtUtil.generateToken(sinhVienDetails);

            // 4. Trả về token cho frontend
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Sai mã sinh viên hoặc mật khẩu");
        }
    }
}
