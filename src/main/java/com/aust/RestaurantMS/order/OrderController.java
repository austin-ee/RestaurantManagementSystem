/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.order;

import com.aust.RestaurantMS.dto.OrderRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("aust/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/all")
    private List<Order> orders(){
     return  orderService.orders();
    }
    @PostMapping
    protected ResponseEntity<?> makeOrder(@RequestBody OrderRequest params){
       if(orderService.create(params)!=null){return ResponseEntity.ok().body("Operation Successful");}
       else{return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Operation Not Successful");}
    }
    @GetMapping("/spec")
    protected Order specificOrder(@RequestParam String id){
        if(id !=null){
          return orderService.specific(Long.parseLong(id));}
        else{return null;}
    }
}
