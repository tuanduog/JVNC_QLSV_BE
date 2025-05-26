package com.edu.student_management_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edu.student_management_backend.model.HocPhan;

@Repository
public interface HocPhanRepo extends JpaRepository<HocPhan, String> {
    Optional<HocPhan> findByMahp(String mahp);
    int deleteByMahp(String mahp);
}
