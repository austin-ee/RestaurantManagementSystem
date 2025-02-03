/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.schedule.Schedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("aust/api/employee")
class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
   //all employees
    @GetMapping("all")
    public List<Employee> employees(){
        return employeeService.employees();
    }
    //employees on leave
    @GetMapping("onleave")
    public List<Employee> onLeave(){
        return employeeService.leaveStatus(true);
    }
    //employees available
    @GetMapping("available")
    public List<Employee> available(){
        return employeeService.leaveStatus(false);
    }
    //individual employee schedule
    @GetMapping("/mySchedule")
    public List<Schedule> mySchedule(){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null && auth.isAuthenticated()){
            return employeeService.employeeSchedule(auth.getName());
        }
        else{return null;}
    }
    //remove employee
    @DeleteMapping("")
    private void deleteEmployee(@RequestBody String id){
        if(id !=null){employeeService.remove(id);}
        
    }
}
