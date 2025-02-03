/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    Reservation reserve(Reservation rs){
        return reservationRepository.save(rs);
    }
    Long generatereservationId(String no){
       LocalDate dt=LocalDate.now();
       LocalTime tm=LocalTime.now();
       String y=String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+dt.getDayOfMonth()+tm.getHour()+tm.getMinute();
       if(no.length()==1){return Long.valueOf(y+"000"+no);}
       else if(no.length()==2){return Long.valueOf(y+"00"+no);}
       else if(no.length()==3){return Long.valueOf(y+"0"+no);}
       else{return Long.valueOf(y+no);}
    } 
    //my Reservations
    List<Reservation> myReservations(String id,String status){
       return reservationRepository.resevations(id,status);
    }
    //all reservations btwn a period*
     List<Reservation> reservations(){
         return reservationRepository.findAll();
     }
}
