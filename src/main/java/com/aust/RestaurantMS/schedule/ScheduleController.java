/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    
    @GetMapping
    public List<Schedule> schedules(){
        return scheduleService.schedules();
    }
}
