package com.edu.student_management_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.student_management_backend.model.Lop;

@Repository
public interface LopRepo extends JpaRepository<Lop, String>{
    Optional<Lop> findByMalop(String malop);
}
