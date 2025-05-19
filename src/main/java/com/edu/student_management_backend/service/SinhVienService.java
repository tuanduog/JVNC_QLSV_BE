package com.edu.student_management_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.SinhVien;
import com.edu.student_management_backend.repository.SinhVienRepo;

@Service
public class SinhVienService {
    @Autowired 
    private SinhVienRepo sinhVienRepo;
    public SinhVien updateSinhVien (String masv, SinhVien sv_new){
        return sinhVienRepo.findByMasv(masv).map(sv -> {
            sv.setGioitinh(sv_new.getGioitinh());
            sv.setNgaysinh(sv_new.getNgaysinh());
            sv.setQuequan(sv_new.getQuequan());
            sv.setSodienthoai(sv_new.getSodienthoai());
            sv.setEmail(sv_new.getEmail());
            return sinhVienRepo.save(sv);
        }).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy sinh viên"));
    }
}
