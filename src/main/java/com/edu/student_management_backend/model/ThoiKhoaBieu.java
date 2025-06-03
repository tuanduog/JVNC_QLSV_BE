package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table ( name = "thoikhoabieu")
public class ThoiKhoaBieu {
    @Id
    private int matkb;
    
    private String masv;

    @ManyToOne
    @JoinColumn(name = "mahp", referencedColumnName = "mahp")
    private HocPhan hocPhan;
    public int getMatkb() {
        return matkb;
    }
    public void setMatkb(int matkb) {
        this.matkb = matkb;
    }
    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public HocPhan getHocPhan() {
        return hocPhan;
    }
    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }
}
