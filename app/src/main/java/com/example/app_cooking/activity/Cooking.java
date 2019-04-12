package com.example.app_cooking.activity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Cooking {
    @SerializedName("hinhanh")
    private String anh;
    @SerializedName("id")
    private int id;
    @SerializedName("tenMonAn")
    private String ten;
    @SerializedName("links")
    private String link;
    @SerializedName("ngay_dang")
    private Date ngay;
    @SerializedName("moTa")
    private String moTa;
    @SerializedName("id_chuDe")
    private  String idChuDe;

    public Cooking(String anh, int id, String ten, String link, Date ngay, String moTa, String idChuDe) {
        this.anh = anh;
        this.id = id;
        this.ten = ten;
        this.link = link;
        this.ngay = ngay;
        this.moTa = moTa;
        this.idChuDe = idChuDe;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdChuDe() {
        return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
        this.idChuDe = idChuDe;
    }
}
