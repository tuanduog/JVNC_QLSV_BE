package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "hocphan_phutrach")
public class HocPhan_GiangVien {
    @Id
    private int mahppt;

    private String magv;
    @ManyToOne
    @JoinColumn(name = "mahp", referencedColumnName = "mahp")
    private HocPhan hocPhan;
    public int getMahppt() {
        return mahppt;
    }
    public void setMahppt(int mahppt) {
        this.mahppt = mahppt;
    }
    public String getMagv() {
        return magv;
    }
    public void setMagv(String magv) {
        this.magv = magv;
    }
    public HocPhan getHocPhan() {
        return hocPhan;
    }
    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }
}
