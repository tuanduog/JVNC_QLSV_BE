package com.edu.student_management_backend.repository;

import com.edu.student_management_backend.model.GiangVien;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepo extends JpaRepository<GiangVien, String>{
    Optional<GiangVien> findByMagv(String magv);
    int deleteByMagv(String magv);
}
