/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.Inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author steve
 */
@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    private Long itemId; 
    private String itemName;
    private int existingQuantity;
    private int reorderLevel;
    private String supplierInfo;  

    public Inventory() {
    }

    public Inventory(Long itemId, String itemName, int existingQuantity, int reorderLevel, String supplierInfo) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.existingQuantity = existingQuantity;
        this.reorderLevel = reorderLevel;
        this.supplierInfo = supplierInfo;
    }
    
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getExistingQuantity() {
        return existingQuantity;
    }

    public void setExistingQuantity(int existingQuantity) {
        this.existingQuantity = existingQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getSupplierInfo() {
        return supplierInfo;
    }

    public void setSupplierInfo(String supplierInfo) {
        this.supplierInfo = supplierInfo;
    }
    
    
}
