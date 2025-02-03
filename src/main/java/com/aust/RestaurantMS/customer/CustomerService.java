/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository ustomerRepository;
    
    
    public List<Customer> customers(){
       return ustomerRepository.findAll();
    }
}
