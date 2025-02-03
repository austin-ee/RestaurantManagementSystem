/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.dto;

/**
 *
 * @author steve
 */
public class OrderRequest {
    private String item;
    private String much;
    private String srequest;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
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
