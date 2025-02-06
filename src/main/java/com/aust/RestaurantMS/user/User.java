/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.user;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author steve
 */
@MappedSuperclass
public abstract class User {
    @Id
    protected String user_id;
    protected String name;
    protected int tel;
    protected String password;

    protected User() {
    }

    protected User(String user_id) {
        this.user_id = user_id;
    }

    public User(String user_id, String name, int tel, String password) {
        this.user_id = user_id;
        this.name = name;
        this.tel = tel;
        this.password = password;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
