/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

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
    private boolean onLeave;
    private float salary;
    @OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
    private List<Schedule> schedules;

    public Employee() {
    }

    public Employee(String user_id,String email, String position, int totalWorkingHours,boolean onLeave,float salary, String name, int tel, String password) {
        super(user_id, name, tel, password);
        this.email = email;
        this.position = position;
        this.totalWorkingHours = totalWorkingHours;
        this.onLeave=onLeave;
        this.salary=salary;
    }
    
    public Employee(String email, String position, int totalWorkingHours,boolean onLeave,float salary, List<Schedule> schedule, String user_id, String name, int tel, String password) {
        super(user_id, name, tel, password);
        this.email = email;
        this.position = position;
        this.totalWorkingHours = totalWorkingHours;
        this.schedules = schedule;
        this.onLeave=onLeave;
        this.salary=salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
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

    public List<Schedule> getSchedules() {
        return this.schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    
    
}
