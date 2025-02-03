/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import com.aust.RestaurantMS.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author steve
 */
@Entity
@Table(name="schedule")
public class Schedule {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleID;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Employee employee;

    private LocalDate date;        
    private LocalTime shiftStart;  
    private LocalTime shiftEnd;    
    private boolean onLeave;   

    public Schedule() {
    }

    public Schedule(Long scheduleID, Employee employee, LocalDate date, LocalTime shiftStart, LocalTime shiftEnd, boolean onLeave) {
        this.scheduleID = scheduleID;
        this.employee = employee;
        this.date = date;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.onLeave = onLeave;
    }
    
    public Long getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Long scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public boolean isOnLeave() {
        return this.onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
    }
    
    
}
