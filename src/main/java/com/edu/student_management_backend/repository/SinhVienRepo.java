package com.edu.student_management_backend.repository;

import com.edu.student_management_backend.model.SinhVien;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepo extends JpaRepository<SinhVien, String>{ // tên entity, kiểu của @Id
    Optional<SinhVien> findByMasv(String masv);
}

// Truy xuất csdl
