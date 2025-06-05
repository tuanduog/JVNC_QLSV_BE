package com.edu.student_management_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.DiemHocPhan;
import com.edu.student_management_backend.model.HocPhan_GiangVien;
import com.edu.student_management_backend.repository.DiemHocPhanRepo;
import com.edu.student_management_backend.repository.HocPhanPhuTrachRepo;

@Service
public class HocPhanPhuTrachService {
    @Autowired
    private HocPhanPhuTrachRepo hocPhanPhuTrachRepo;
    @Autowired
    private DiemHocPhanRepo diemHocPhanRepo;

    public List<HocPhan_GiangVien> getAllHocPhan_GiangVien(String magv){
        return hocPhanPhuTrachRepo.findAllByMagv(magv);
    }

    public List<DiemHocPhan> getAllSVInHocphan(String mahp){
        return diemHocPhanRepo.findAllByHocPhan_Mahp(mahp);
    }

    public DiemHocPhan updateDiem(int madhp, DiemHocPhan diemsv){
        return diemHocPhanRepo.findByMadhp(madhp).map(sv -> {
            sv.setDiemtx1(diemsv.getDiemtx1());
            sv.setDiemtx2(diemsv.getDiemtx2());
            sv.setDiemgk(diemsv.getDiemgk());
            sv.setDiemck(diemsv.getDiemck());
            return diemHocPhanRepo.save(sv);
        }).orElseThrow(() -> new UsernameNotFoundException("Không tìm thay diem"));
    }
}
