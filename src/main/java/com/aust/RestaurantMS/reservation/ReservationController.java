/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.reservation;

import com.aust.RestaurantMS.dto.ReservationRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("aust/api/reserve")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @PostMapping
    public ResponseEntity<?> reserve(@RequestBody ReservationRequest params){
           Reservation rs=reservationService.reserve(params);
        return ResponseEntity.ok().body("Processing");
        }
    //employees reservation
    @GetMapping
    public List<Reservation> myReservations(@RequestParam String status){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null&& auth.isAuthenticated()){
           return   reservationService.myReservations(auth.getName(), status);
        }
        else{return null;}
    }
    //
    @GetMapping("/all")
    public List<Reservation> reservations(){
        return reservationService.reservations();
    }
}
