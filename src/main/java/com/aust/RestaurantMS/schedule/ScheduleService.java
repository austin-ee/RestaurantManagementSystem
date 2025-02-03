/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author steve
 */
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    
    protected List<Schedule> schedules(){
     return scheduleRepository.findAll();
    }
}
