package com.edu.student_management_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.edu.student_management_backend.model.DiemHocPhan;

@Repository
public interface DiemHocPhanRepo extends JpaRepository<DiemHocPhan, Integer>{
    List<DiemHocPhan> findAllByMasv(String masv);

    List<DiemHocPhan> findAllByHocPhan_Mahp(String mahp);

    Optional<DiemHocPhan> findByMadhp(int madhp);
}
