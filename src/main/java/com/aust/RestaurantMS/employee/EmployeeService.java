/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.dto.RegisterRequest;
import com.aust.RestaurantMS.schedule.Schedule;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncorder;
    
    protected List<Employee> employees(){
        return employeeRepository.findEmployees();
    }
    protected List<Employee> leaveStatus(boolean b){
       return employeeRepository.leaveStatus(b);
    }
    public Employee createEmployee(RegisterRequest params){
        String id=generateId(params.getPosition(),params.getName());
        params.setPassword(passwordEncorder.encode(params.getPassword()));
        return (id==null)?null:employeeRepository.save(new Employee(id,params.getEmail(),params.getPosition(),
        Integer.parseInt(params.getTwh()),false,calculateSalary(),params.getName(),Integer.parseInt(params.getTel()),params.getPassword()));
    }
    protected void remove(String id){
       employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
    public Employee empDetails(String id){
        return employeeRepository.getReferenceById(id);
    }
    
    private float calculateSalary(){
        return 0.0f;
    }
    private String generateId(String pos,String name){
       String []nm=name.toLowerCase().split(" "); String y=null; 
       LocalDate dt=LocalDate.now();
       switch(pos){
           case "manager" ->  y=String.valueOf(11)+String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+String.valueOf(10*Math.random())+nm[0].substring(0,1)+nm[1].substring(0,1);
           case "operator" -> y=String.valueOf(21)+String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+String.valueOf(10*Math.random())+nm[0].substring(0,1)+nm[1].substring(0,1);
           case "wait" -> y=String.valueOf(22)+String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+String.valueOf(10*Math.random())+nm[0].substring(0,1)+nm[1].substring(0,1);
           default ->y=null;}
           return y;
    } 
}
