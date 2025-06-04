package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "diemhocphan")
public class DiemHocPhan {
    @Id
    private int madhp;

    private String masv;
    @ManyToOne
    @JoinColumn(name = "mahp", referencedColumnName = "mahp")
    private HocPhan hocPhan;
    private float diemtx1;
    private float diemtx2;
    private float diemgk;
    private float diemck;
    public int getMadhp() {
        return madhp;
    }
    public void setMadhp(int madhp) {
        this.madhp = madhp;
    }
    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public float getDiemtx1() {
        return diemtx1;
    }
    public HocPhan getHocPhan() {
        return hocPhan;
    }
    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }
    public void setDiemtx1(float diemtx1) {
        this.diemtx1 = diemtx1;
    }
    public float getDiemtx2() {
        return diemtx2;
    }
    public void setDiemtx2(float diemtx2) {
        this.diemtx2 = diemtx2;
    }
    public float getDiemgk() {
        return diemgk;
    }
    public void setDiemgk(float diemgk) {
        this.diemgk = diemgk;
    }
    public float getDiemck() {
        return diemck;
    }
    public void setDiemck(float diemck) {
        this.diemck = diemck;
    }
    
}
