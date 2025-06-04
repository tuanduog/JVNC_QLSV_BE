package com.edu.student_management_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.student_management_backend.model.HocPhan_GiangVien;

@Repository
public interface HocPhanPhuTrachRepo extends JpaRepository<HocPhan_GiangVien, Integer>{
    List<HocPhan_GiangVien> findAllByMagv(String magv);
}
