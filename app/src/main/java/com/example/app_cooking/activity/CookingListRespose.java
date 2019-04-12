package com.example.app_cooking.activity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CookingListRespose {
    @SerializedName("status")
    private  boolean status;
    @SerializedName("msg")
    private String mess;
    @SerializedName("data")
    private List<Cooking> cookList;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public List<Cooking> getCookList() {
        return cookList;
    }

    public void setCookList(List<Cooking> cookList) {
        this.cookList = cookList;
    }
}
