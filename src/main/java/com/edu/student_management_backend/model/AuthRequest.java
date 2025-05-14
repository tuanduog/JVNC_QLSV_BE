package com.edu.student_management_backend.model;

public class AuthRequest {
    private String masv;
    private String matkhau;
    private boolean remember;

    public AuthRequest(String masv, String matkhau, boolean remember) {
        this.masv = masv;
        this.matkhau = matkhau;
        this.remember = remember;
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
    public boolean isRemember() {
        return remember;
    }
    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
