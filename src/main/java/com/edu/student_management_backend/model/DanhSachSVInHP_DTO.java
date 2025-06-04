package com.edu.student_management_backend.model;

import java.util.List;

public class DanhSachSVInHP_DTO {
    private String mahp;
    private String tenhp;
    private List<DiemHocPhan> svs;

    
    public DanhSachSVInHP_DTO(String mahp, String tenhp, List<DiemHocPhan> svs) {
        this.mahp = mahp;
        this.tenhp = tenhp;
        this.svs = svs;
    }
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
    public List<DiemHocPhan> getSvs() {
        return svs;
    }
    public void setSvs(List<DiemHocPhan> svs) {
        this.svs = svs;
    }
    
    
}
