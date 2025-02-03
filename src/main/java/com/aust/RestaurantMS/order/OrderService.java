/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.order;

import com.aust.RestaurantMS.customer.CustomerRepository;
import com.aust.RestaurantMS.dto.OrderRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository oderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    
    protected List<Order> orders(){
        return oderRepository.orders();
    }
    protected Order create(OrderRequest params){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null && auth.isAuthenticated()){
         return oderRepository.save(new Order(23455L,customerRepository.getReferenceById(auth.getName()),
         params.getItem(),Integer.parseInt(params.getMuch()),params.getSrequest(),"Not Served"));}
        else{return null;}
    }
    protected Order specific(Long id){
         Optional<Order> opt=oderRepository.findById(id);
         if(opt.isPresent()){return opt.get();}
         else{return null;}
    }
}
