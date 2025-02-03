/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.reservation.Reservation;
import com.aust.RestaurantMS.schedule.Schedule;
import com.aust.RestaurantMS.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author steve
 */
@Entity
@Table(name="employee")
public class Employee extends User{//Employee uses user_id which is the same as employee-id to login in 
    private String email;
    private String position;  
    private int totalWorkingHours;
    @OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
    private List<Schedule> schedules;

    public Employee() {
    }

    public Employee(String user_id,String email, String position, int totalWorkingHours, String name, int tel, String password) {
        super(user_id, name, tel, password);
        this.email = email;
        this.position = position;
        this.totalWorkingHours = totalWorkingHours;
    }
    
    public Employee(String email, String position, int totalWorkingHours, List<Schedule> schedule, String user_id, String name, int tel, String password) {
        super(user_id, name, tel, password);
        this.email = email;
        this.position = position;
        this.totalWorkingHours = totalWorkingHours;
        this.schedules = schedule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(int totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }

    public List<Schedule> getSchedule() {
        return schedules;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedules = schedule;
    }
    
    
}
