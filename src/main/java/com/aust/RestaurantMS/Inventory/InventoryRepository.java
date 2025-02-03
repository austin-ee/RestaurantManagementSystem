/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.Inventory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    @Query(value="SELECT * FROM inventory i",nativeQuery=true)
    List<Inventory> inventory();
    @Query(value="UPDATE inventory SET existing_quantity=existing_quantity-?2 WHERE item_id=?1",nativeQuery=true)
    int getItem(Long id,int quant);
    @Query(value="SELECT existing_quantity from inventory WHERE item_id=?1",nativeQuery=true)
    int itemnumber(Long id);
     
}
