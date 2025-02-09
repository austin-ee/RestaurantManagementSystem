/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.dto;

import java.util.List;

/**
 *
 * @author steve
 */
public class OrderRequest {
    private List<String> item;
    private String much;
    private String srequest;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    public String getMuch() {
        return much;
    }

    public void setMuch(String much) {
        this.much = much;
    }

    public String getSrequest() {
        return srequest;
    }

    public void setSrequest(String srequest) {
        this.srequest = srequest;
    }
    
    
}
