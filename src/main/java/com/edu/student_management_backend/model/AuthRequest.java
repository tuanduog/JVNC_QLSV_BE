package com.edu.student_management_backend.model;

public class AuthRequest {
    private String tendn;
    private String matkhau;
    private boolean remember;

    public AuthRequest(String tendn, String matkhau, boolean remember) {
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.remember = remember;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
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
