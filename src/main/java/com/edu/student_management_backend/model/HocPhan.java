package com.edu.student_management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hocphan")
public class HocPhan {
    @Id
    private String mahp;

    private String tenhp;
    private int sotc;
    private String ngayhoc;
    private String phonghoc;
    private String cahoc;
    public String getMahp() {
        return mahp;
    }
    public void setMahp(String mahp) {
        this.mahp = mahp;
    }
    public String getTenhp() {
        return tenhp;
    }
    public void setTenhp(String tenhp) {
        this.tenhp = tenhp;
    }
    public int getSotc() {
        return sotc;
    }
    public void setSotc(int sotc) {
        this.sotc = sotc;
    }
    public String getNgayhoc() {
        return ngayhoc;
    }
    public void setNgayhoc(String ngayhoc) {
        this.ngayhoc = ngayhoc;
    }
    public String getPhonghoc() {
        return phonghoc;
    }
    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }
    public String getCahoc() {
        return cahoc;
    }
    public void setCahoc(String cahoc) {
        this.cahoc = cahoc;
    }
    
}
