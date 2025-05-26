package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phanhoi")
public class PhanHoi {
    @Id
    private int maph;

    private String noidung;
    private String trangthai;
    public int getMaph() {
        return maph;
    }
    public void setMaph(int maph) {
        this.maph = maph;
    }
    public String getNoidung() {
        return noidung;
    }
    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    public String getTrangthai() {
        return trangthai;
    }
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
