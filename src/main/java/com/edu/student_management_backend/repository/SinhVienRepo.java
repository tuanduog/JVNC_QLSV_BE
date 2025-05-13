package com.edu.student_management_backend.repository;

import com.edu.student_management_backend.model.SinhVien;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienRepo extends JpaRepository<SinhVien, String>{
    Optional<SinhVien> findByMasv(String masv);
}
