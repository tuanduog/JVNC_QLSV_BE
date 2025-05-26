package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.GiangVien;
import com.edu.student_management_backend.repository.GiangVienRepo;

import jakarta.transaction.Transactional;

@Service
public class GiangVienService {
    @Autowired
    private GiangVienRepo giangVienRepo;
    public GiangVien updateGiangVien(String magv, GiangVien gv_new){
        return giangVienRepo.findByMagv(magv).map(gv -> {
            gv.setNgaysinh(gv_new.getNgaysinh());
            gv.setQuequan(gv_new.getQuequan());
            gv.setGioitinh(gv_new.getGioitinh());
            gv.setSodienthoai(gv_new.getSodienthoai());
            gv.setEmail(gv_new.getEmail());
            return giangVienRepo.save(gv);
        }).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy giảng viên"));
    }

    public List<GiangVien> getAllGiangVien(){
        return giangVienRepo.findAll();
    }
    @Transactional
    public boolean deleteGiangVien(String magv){
        int res = giangVienRepo.deleteByMagv(magv);
        if(res > 0){
            return true;
        }
        return false;
    }

    public GiangVien addGiangVien(GiangVien gv){
        return giangVienRepo.save(gv);
    }

    public GiangVien adUpdateGiangVien(String magv, GiangVien gv_new){
        return giangVienRepo.findByMagv(magv).map(gv -> {
            gv.setHovaten(gv_new.getHovaten());
            gv.setGioitinh(gv_new.getGioitinh());
            gv.setNgaysinh(gv_new.getNgaysinh());
            gv.setQuequan(gv_new.getQuequan());
            gv.setSodienthoai(gv_new.getSodienthoai());
            gv.setEmail(gv_new.getEmail());
            return giangVienRepo.save(gv);
        }).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy sinh viên"));
    }
}
