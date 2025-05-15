package com.edu.student_management_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "giangvien")
public class GiangVien {
    @Id
    private String magv;

    private String hovaten;
    private String gioitinh;
    private String ngaysinh;
    private String quequan;
    private String sodt;
    private String email;
    private String matkhau;
    private String quyen_nd;
    

    public GiangVien() {
    }
    public GiangVien(String magv, String hovaten, String gioitinh, String ngaysinh, String quequan, String sodt,
            String email, String matkhau, String quyen_nd) {
        this.magv = magv;
        this.hovaten = hovaten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.sodt = sodt;
        this.email = email;
        this.matkhau = matkhau;
        this.quyen_nd = quyen_nd;
    }
    public String getMagv() {
        return magv;
    }
    public void setMagv(String magv) {
        this.magv = magv;
    }
    public String getHovaten() {
        return hovaten;
    }
    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }
    public String getGioitinh() {
        return gioitinh;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public String getNgaysinh() {
        return ngaysinh;
    }
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public String getQuequan() {
        return quequan;
    }
    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    public String getSodt() {
        return sodt;
    }
    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    public String getQuyen_nd() {
        return quyen_nd;
    }
    public void setQuyen_nd(String quyen_nd) {
        this.quyen_nd = quyen_nd;
    }
}
