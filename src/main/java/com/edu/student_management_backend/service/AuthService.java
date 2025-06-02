package com.edu.student_management_backend.service;

import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.repository.SinhVienRepo;
import com.edu.student_management_backend.model.Admin;
import com.edu.student_management_backend.model.CustomerDetail;
import com.edu.student_management_backend.model.GiangVien;
import com.edu.student_management_backend.repository.AdminRepo;
import com.edu.student_management_backend.repository.GiangVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Annotation
public class AuthService implements UserDetailsService {
    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private GiangVienRepo giangVienRepo;

    @Autowired
    private AdminRepo adminRepo;

    public UserDetails loadUserByUsername(String tendn) throws UsernameNotFoundException {
        SinhVien sv = sinhVienRepo.findByMasv(tendn).orElse(null);
        if(sv != null){
            return new CustomerDetail(sv.getMasv(), sv.getMatkhau(), sv.getHovaten(), List.of(new SimpleGrantedAuthority(sv.getQuyen_nd())));
        }

        GiangVien gv = giangVienRepo.findByMagv(tendn).orElse(null);
        if(gv != null){
            return new CustomerDetail(gv.getMagv(), gv.getMatkhau(), gv.getHovaten(), List.of(new SimpleGrantedAuthority(gv.getQuyen_nd())));
        }

        Admin admin = adminRepo.findByMaqt(tendn).orElse(null);
        if(admin != null){
            return new CustomerDetail(admin.getMaqt(), admin.getMatkhau(), admin.getHovaten(), List.of(new SimpleGrantedAuthority(admin.getQuyen_nd())));
        }
        throw new UsernameNotFoundException("Không tìm thấy người dùng");
    }
    
}

// Xử lý logic
