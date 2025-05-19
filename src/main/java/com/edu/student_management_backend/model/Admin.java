package com.edu.student_management_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quantri")
public class Admin {
    @Id
    private String maqt;

    private String hovaten;
    private String matkhau;
    private String quyen_nd;
    public String getMaqt() {
        return maqt;
    }
    public void setMaqt(String maqt) {
        this.maqt = maqt;
    }
    public String getHovaten() {
        return hovaten;
    }
    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
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
