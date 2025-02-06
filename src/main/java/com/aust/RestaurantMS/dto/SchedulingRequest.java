/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.dto;

/**
 *
 * @author steve
 */
public class SchedulingRequest {
    private String empid;
    private String date;
    private String start;
    private String end;
    private String sdlid;

    public String getSdlid() {
        return sdlid;
    }

    public void setSdlid(String sdlid) {
        this.sdlid = sdlid;
    }

    
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    
}
