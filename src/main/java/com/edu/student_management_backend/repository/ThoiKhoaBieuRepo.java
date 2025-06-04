package com.edu.student_management_backend.repository;

import com.edu.student_management_backend.model.ThoiKhoaBieu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ThoiKhoaBieuRepo extends JpaRepository<ThoiKhoaBieu, Integer>{
    List<ThoiKhoaBieu> findAllByMasv(String masv);
}
