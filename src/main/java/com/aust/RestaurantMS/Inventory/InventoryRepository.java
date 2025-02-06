/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    @Modifying
    @Query(value="UPDATE inventory SET existing_quantity=?2 WHERE item_id=?1",nativeQuery=true)
    void getItem(Long id,int quant);
    @Query(value="SELECT existing_quantity from inventory WHERE item_id=?1",nativeQuery=true)
    int itemnumber(Long id);
     
}
