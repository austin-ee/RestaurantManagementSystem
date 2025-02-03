/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("aust/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/all")
    public List<Customer> customers(){
        return customerService.customers();
    }
}
