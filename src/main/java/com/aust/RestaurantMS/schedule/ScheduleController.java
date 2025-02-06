/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import com.aust.RestaurantMS.dto.SchedulingRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("/aust/api/sched")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    
    @GetMapping("/all")
    public List<Schedule> schedules(){
        return scheduleService.schedules();
    }
    //employee schedule
    @PostMapping("/ems")
    public List<Schedule> empSchedule(@RequestParam String id){
        return scheduleService.employeeSchedule(id);
    }
    //create 
    @PostMapping("/cts")
    public void createSchedule(@RequestBody SchedulingRequest params){
        scheduleService.create(params);
    }
    //cancel
    @PostMapping("/cnl")
    public void cancel(@RequestParam("employee") String id){
        scheduleService.cancelSchedule(Long.parseLong(id));
    }
    //update
    @PostMapping("/upt")
    public void updateSchedule(@RequestBody SchedulingRequest params){
        scheduleService.update(params);
    }    
}
