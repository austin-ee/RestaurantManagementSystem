/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.dto.RegisterRequest;
import com.aust.RestaurantMS.schedule.Schedule;
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
        params.setPassword(passwordEncorder.encode(params.getPassword()));
        return employeeRepository.save(new Employee("112233as",params.getEmail(),params.getPosition(),
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
}
