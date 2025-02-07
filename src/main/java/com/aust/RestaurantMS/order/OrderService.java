/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.order;

import com.aust.RestaurantMS.customer.CustomerRepository;
import com.aust.RestaurantMS.dto.OrderRequest;
import com.aust.RestaurantMS.menuitem.MenuItemRepository;
import java.time.LocalDate;
import java.time.LocalTime;
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
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    
    protected List<Order> orders(){
        return oderRepository.orders();
    }
    protected Order create(OrderRequest params){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null && auth.isAuthenticated()){
         return oderRepository.save(new Order(generateId(),customerRepository.getReferenceById(auth.getName()),
         menuItemRepository.getReferenceById(params.getItem()),Integer.parseInt(params.getMuch()),params.getSrequest(),"Pending",LocalTime.now()));}
        else{return null;}
    }
    protected Order specific(Long id){
         Optional<Order> opt=oderRepository.findById(id);
         if(opt.isPresent()){return opt.get();}
         else{return null;}
    }
    protected void updateStatus(Long id,String status){
        oderRepository.update(id, status);
    }
    protected List<Order> customerOrders(String id){
        return oderRepository.customerOrders(id);
    }
    protected float generateBill(Long orderid){
        return 0.0f;
    }
    private Long generateId(){
       LocalDate dt=LocalDate.now();
       LocalTime tm=LocalTime.now();
       String y=String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+dt.getDayOfMonth()+tm.getHour()+tm.getMinute()+String.valueOf(10*Math.random());
       return Long.valueOf(y);
    } 
}
