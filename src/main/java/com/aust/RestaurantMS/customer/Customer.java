/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.customer;

import com.aust.RestaurantMS.reservation.Reservation;
import com.aust.RestaurantMS.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author steve
 */
@Entity
@Table(name="customer")
public class Customer extends User{
    private String location;
    @OneToMany(mappedBy="user")
    private List<Reservation> reservations;

    public Customer() {
    }

    public Customer(String location, List<Reservation> reservations, String user_id, String name, int tel, String password) {
        super(user_id, name, tel, password);
        this.location = location;
        this.reservations = reservations;
    }

    public Customer(String user_id) {
        super(user_id);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
}
