package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "lop")
public class Lop {
    @Id
    private String malop;

    private String tenlop;
    private String manganh;
    public String getMalop() {
        return malop;
    }
    public void setMalop(String malop) {
        this.malop = malop;
    }
    public String getTenlop() {
        return tenlop;
    }
    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
    public String getManganh() {
        return manganh;
    }
    public void setManganh(String manganh) {
        this.manganh = manganh;
    }
    
}
