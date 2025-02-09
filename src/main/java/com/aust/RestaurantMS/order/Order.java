/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.order;

import com.aust.RestaurantMS.customer.Customer;
import com.aust.RestaurantMS.menuitem.MenuItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author steve
 */
@Entity
@Table(name="orderDetails")
public class Order {
    @Id
    private Long orderID;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    @ManyToMany
    private List<MenuItem> menuItem;
    private int quantity;
    private String specialRequests;
    private String status; 
    private LocalTime ordertime;

    public Order() {
    }

    public Order(Long orderID, Customer customer, List<MenuItem> menuItem, int quantity, String specialRequests, String status, LocalTime ordertime) {
        this.orderID = orderID;
        this.customer = customer;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.specialRequests = specialRequests;
        this.status = status;
        this.ordertime = ordertime;
    }

    public LocalTime getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalTime ordertime) {
        this.ordertime = ordertime;
    }


    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<MenuItem> getOrderItem() {
        return menuItem;
    }

    public void setoderItem(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
