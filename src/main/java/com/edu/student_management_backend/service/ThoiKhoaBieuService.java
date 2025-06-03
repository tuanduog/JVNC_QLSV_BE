package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.ThoiKhoaBieu;
import com.edu.student_management_backend.repository.ThoiKhoaBieuRepo;

@Service
public class ThoiKhoaBieuService {
    @Autowired
    private ThoiKhoaBieuRepo thoiKhoaBieuRepo;

    public List<ThoiKhoaBieu> getAlltkb(String masv){
        return thoiKhoaBieuRepo.findAllByMasv(masv);
    }
}
