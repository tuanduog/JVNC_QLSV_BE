package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
