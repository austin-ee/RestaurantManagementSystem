/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import com.aust.RestaurantMS.dto.SchedulingRequest;
import com.aust.RestaurantMS.employee.EmployeeRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    
    protected List<Schedule> schedules(){
     return scheduleRepository.findAll();
    }
    protected List<Schedule> employeeSchedule(String id){
       return scheduleRepository.empSchedule(id);
    }
    protected Schedule create(SchedulingRequest params){
        return scheduleRepository.save(new Schedule(121213L,employeeRepository.getReferenceById(params.getEmpid()),
        LocalDate.parse(params.getDate()),LocalTime.parse(params.getStart()),LocalTime.parse(params.getEnd())));
    }
    protected void update(SchedulingRequest params){
        scheduleRepository.update(Long.parseLong(params.getSdlid()),LocalDate.parse(params.getDate()),LocalTime.parse(params.getStart()),
               LocalTime.parse(params.getEnd()),params.getEmpid());
    }
    protected void cancelSchedule(Long id){
        scheduleRepository.delete(scheduleRepository.getReferenceById(id));
    }
        
}
