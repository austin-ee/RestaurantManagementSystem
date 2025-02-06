/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.schedule.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/alle")
    public List<Employee> employees(){
        return employeeService.employees();
    }
    //employees on leave
    @GetMapping("/lst")
    public List<Employee> leaveStatus(){
        return employeeService.leaveStatus(true);
    }
    //remove employee from system
    @DeleteMapping("/del")
    public void deleteEmployee(@RequestBody String id){
        if(id !=null){employeeService.remove(id);}
    }
  
}
