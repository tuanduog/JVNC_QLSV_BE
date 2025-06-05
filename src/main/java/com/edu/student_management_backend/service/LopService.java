package com.edu.student_management_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.Lop;
import com.edu.student_management_backend.repository.LopRepo;

@Service
public class LopService {
    @Autowired
    private LopRepo lopRepo;

    public Lop getLopInfo(String malop){
        Optional<Lop> lp = lopRepo.findByMalop(malop);
        if(!lp.isPresent()){
            return null;
        }
        return lp.get();
    }
}
