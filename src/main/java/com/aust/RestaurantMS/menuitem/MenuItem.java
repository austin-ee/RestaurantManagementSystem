/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.menuitem;

import com.aust.RestaurantMS.order.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author steve
 */
@Entity
@Table(name="menuItem")
public class MenuItem {
    @Id
    private String menuId;
    private String name;
    private String type;
    private String items;
    private int price;
    @ManyToMany(mappedBy="menuItem",cascade=CascadeType.ALL)
    private List<Order> orders;

    public MenuItem() {
    }

    public MenuItem(String menuId, String name, String type, String items,int price) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.items = items;
        this.price=price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
    
    
}
