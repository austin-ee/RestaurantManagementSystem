/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.reservation;

import com.aust.RestaurantMS.customer.Customer;
import com.aust.RestaurantMS.dto.ReservationRequest;
import com.aust.RestaurantMS.table.TableDetails;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation reserve(ReservationRequest params){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null&& auth.isAuthenticated()){
           Reservation rs=reservationRepository.save(new Reservation(generatereservationId("5"),
           new TableDetails(Long.valueOf(params.getTable())),LocalDate.parse(params.getDate()),
           LocalTime.parse(params.getTime()),Integer.parseInt(params.getGuests()),"Pendimg",new Customer("112233as")));/*new Customer(auth.getName())*/
        return (rs!=null)?rs:null;
        }
        else{return null;}
    }
    //my Reservations
    protected List<Reservation> myReservations(String id,String status){
       return reservationRepository.myresevations(id,status);
    }
    //all reservations btwn a period*
    protected List<Reservation> reservations(){
         return reservationRepository.findAll();
     }
    protected Reservation reservationDetails(Long id){
        return reservationRepository.getReferenceById(id);
    }
    protected void updateReservation(Long id,String status){
        reservationRepository.update(id, status);
    }
    
    private Long generatereservationId(String no){
       LocalDate dt=LocalDate.now();
       LocalTime tm=LocalTime.now();
       String y=String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+dt.getDayOfMonth()+tm.getHour()+tm.getMinute();
       if(no.length()==1){return Long.valueOf(y+"000"+no);}
       else if(no.length()==2){return Long.valueOf(y+"00"+no);}
       else if(no.length()==3){return Long.valueOf(y+"0"+no);}
       else{return Long.valueOf(y+no);}
    } 
}
