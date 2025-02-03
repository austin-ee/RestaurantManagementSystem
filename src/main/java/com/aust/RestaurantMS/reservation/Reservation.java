/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.reservation;

import com.aust.RestaurantMS.customer.Customer;
import com.aust.RestaurantMS.table.TableDetails;
import com.aust.RestaurantMS.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author steve
 */
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    private Long reservationId;
    @ManyToOne
    @JoinColumn(name="tableNo", nullable=false)
    private TableDetails tabledet;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private int numberOfGuests;
    private String status;
    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private Customer user;  //to look later /..effects of generalization on db retrieval

    public Reservation() {
    }

    public Reservation(Long reservationId, TableDetails tabledet, LocalDate reservationDate, LocalTime reservationTime, int numberOfGuests, String status, Customer user) {
        this.reservationId = reservationId;
        this.tabledet = tabledet;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
        this.user = user;
    }
    
  

     
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TableDetails getTabledet() {
        return tabledet;
    }

    public void setTabledet(TableDetails tabledet) {
        this.tabledet = tabledet;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }
    
}
