package com.example.app_cooking.activity;

import com.google.gson.annotations.SerializedName;

public class ChuDe {
    @SerializedName("id")
    private int idCD;
    @SerializedName("tenChuDe")
    private  String tenChuDe;

    public ChuDe(int idCD, String tenChuDe) {
        this.idCD = idCD;
        this.tenChuDe = tenChuDe;
    }

    public ChuDe() {
    }

    public int getIdCD() {
        return idCD;
    }

    public void setIdCD(int idCD) {
        this.idCD = idCD;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }
}
