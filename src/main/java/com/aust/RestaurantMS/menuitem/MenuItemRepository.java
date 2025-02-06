/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aust.RestaurantMS.menuitem;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
    @Modifying
    @Query(value="UPDATE menuItem SET items=?2,type=?3,price=?4 WHERE menuId=?1",nativeQuery=true)
    void updateItem(Long id,String items,String type,String price);
    @Query(value="Select * from menuItem WHERE type=?1",nativeQuery=true)
    List<MenuItem> typeMenu(String type);
}
