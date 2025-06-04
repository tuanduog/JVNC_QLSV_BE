package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.repository.DiemHocPhanRepo;
import com.edu.student_management_backend.model.DanhSachSVInHP_DTO;
import com.edu.student_management_backend.model.DiemHocPhan;

@Service
public class DiemHocPhanService {
    @Autowired
    private DiemHocPhanRepo diemHocPhanRepo;

    public List<DiemHocPhan> getAllDiemHocPhan(String masv){
        return diemHocPhanRepo.findAllByMasv(masv);
    }
}
