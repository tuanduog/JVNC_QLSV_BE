package com.edu.student_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public HocPhan addHocPhan(HocPhan hp){
        return hocPhanRepo.save(hp);
    }

    public HocPhan adUpdateHocPhan(String mahp, HocPhan hp_new){
        return hocPhanRepo.findByMahp(mahp).map(hp -> {
            hp.setTenhp(hp_new.getTenhp());
            hp.setSotc(hp_new.getSotc());
            hp.setPhonghoc(hp_new.getPhonghoc());
            hp.setNgayhoc(hp_new.getNgayhoc());
            hp.setCahoc(hp_new.getCahoc());
            return hocPhanRepo.save(hp);
        }).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy học phần"));
    }
}
