package com.edu.student_management_backend.service;

import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.repository.SinhVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service // Annotation
public class SinhVienService implements UserDetailsService {
    @Autowired
    private SinhVienRepo sinhVienRepo;

    public UserDetails loadUserByUsername(String masv) throws UsernameNotFoundException {
        SinhVien sv = sinhVienRepo.findByMasv(masv)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy sinh viên"));

        return new User(sv.getMasv(), sv.getMatkhau(), new ArrayList<>());
    }
    
}

// Xử lý logic
