package com.edu.student_management_backend.model;

import jakarta.persistence.*;

@Entity // đánh dấu SinhVien là 1 entity đại diện cho 1 bảng trong db
@Table(name = "sinhvien") // chỉ tên bảng tường ứng trong db
public class SinhVien {
    @Id
    private String masv;

    private String hovaten;
    private String gioitinh;
    private String ngaysinh;
    private String quequan;
    private String sodienthoai;
    private String email;
    private String matkhau;
    private String quyen_nd;
    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
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
    public String getSodienthoai() {
        return sodienthoai;
    }
    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
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
