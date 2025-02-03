/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.user;

import com.aust.RestaurantMS.dto.LoginRequest;
import com.aust.RestaurantMS.dto.RegisterRequest;
import com.aust.RestaurantMS.employee.Employee;
import com.aust.RestaurantMS.employee.EmployeeRepository;
import com.aust.RestaurantMS.employee.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("aust/api")
public class UserManagement {
    private AuthenticationManager authManager;
    private EmployeeService employeeService;
    @Autowired
    public UserManagement(AuthenticationManager authenticationManager,EmployeeService employeeService){
        this.authManager=authenticationManager;
        this.employeeService=employeeService;}
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest params){
     Authentication auth=authManager.authenticate(new UsernamePasswordAuthenticationToken(params.getId(),
             params.getPassword()));
     
     if(auth.isAuthenticated()){
         return ResponseEntity.ok().body("Login Successful");
     }
     else{
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username and password");
     }
    }
     @PostMapping("/register")
     public ResponseEntity<?> register(@RequestBody RegisterRequest params){
        Employee employee=employeeService.createEmployee(params);
        if(employee !=null){return ResponseEntity.ok().body("Employee added Successfully");}
        else{
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Operation Failed");
        }
     }
}
