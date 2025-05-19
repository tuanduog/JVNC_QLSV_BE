package com.edu.student_management_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.student_management_backend.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{
    Optional<Admin> findByMaqt(String maqt);
}
