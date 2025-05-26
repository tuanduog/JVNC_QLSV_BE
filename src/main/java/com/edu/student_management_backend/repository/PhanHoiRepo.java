package com.edu.student_management_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edu.student_management_backend.model.PhanHoi;

@Repository
public interface PhanHoiRepo extends JpaRepository<PhanHoi, Integer>{
    Optional<PhanHoi> findByMaph(int maph);
    int deleteByMaph(int maph);
}
