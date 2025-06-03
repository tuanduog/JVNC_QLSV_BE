package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.PhanHoi;
import com.edu.student_management_backend.repository.PhanHoiRepo;

@Service
public class PhanHoiService {
    @Autowired
    private PhanHoiRepo phanHoiRepo;
    
    public List<PhanHoi> getAllPhanHoi(){
        return phanHoiRepo.findAll();
    }

    public boolean deletePhanhoi(int maph){
        int res = phanHoiRepo.deleteByMaph(maph);
        if(res > 0){
            return true;
        }
        return false;
    }

    public PhanHoi addPhanHoi(PhanHoi ph){
        return phanHoiRepo.save(ph);
    }
}
