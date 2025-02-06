/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.user;

import com.aust.RestaurantMS.dto.ReservationRequest;
import com.aust.RestaurantMS.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
public class OperationsManager {
    @Autowired
    private ReservationService reservationService;
    
    public void rervationProcessing(ReservationRequest params){
        try{
           reservationService.reserve(params);
           
        }
        catch(Exception e){}
    }
}
