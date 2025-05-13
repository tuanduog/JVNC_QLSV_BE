package com.edu.student_management_backend.model;

public class AuthRequest {
    private String masv;
    private String matkhau;

    public AuthRequest(String masv, String matkhau) {
        this.masv = masv;
        this.matkhau = matkhau;
    }
    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
