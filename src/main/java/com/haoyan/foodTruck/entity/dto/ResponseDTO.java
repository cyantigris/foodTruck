package com.haoyan.foodTruck.entity.dto;

import com.haoyan.foodTruck.entity.SearchEntity;

import java.util.List;

public class ResponseDTO {
    private int code;
    private List<SearchEntity> message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SearchEntity> getMessage() {
        return message;
    }

    public void setMessage(List<SearchEntity> message) {
        this.message = message;
    }

}
