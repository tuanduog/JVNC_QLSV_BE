package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.student_management_backend.model.HocPhan;
import com.edu.student_management_backend.repository.HocPhanRepo;


@Service
public class HocPhanService {
    @Autowired
    private HocPhanRepo hocPhanRepo;

    public List<HocPhan> getAllHocphan(){
        return hocPhanRepo.findAll();
    }

    public boolean deleteHocphan(String mahp){
        int res = hocPhanRepo.deleteByMahp(mahp);
        if(res > 0){
            return true;
        }
        return false;
    }
}
