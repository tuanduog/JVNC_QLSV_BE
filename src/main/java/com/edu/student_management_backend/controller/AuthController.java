package com.edu.student_management_backend.controller;

import com.edu.student_management_backend.model.AuthRequest;
import com.edu.student_management_backend.model.AuthResponse;
import com.edu.student_management_backend.service.AuthService;
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
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

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
}
