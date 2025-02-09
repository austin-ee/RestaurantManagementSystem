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
public class TableAdRequest {
   private String chairs;
   private String location;
   private String id;
   private String reservations;
   private String condition;

    public TableAdRequest() {
    }

    public TableAdRequest(String id, String chairs, String reservations, String condition) {
        this.chairs = chairs;
        this.id = id;
        this.reservations = reservations;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReservations() {
        return reservations;
    }

    public void setReservations(String reservations) {
        this.reservations = reservations;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    public String getChairs() {
        return chairs;
    }

    public void setChairs(String chairs) {
        this.chairs = chairs;
    }
   
   
}
