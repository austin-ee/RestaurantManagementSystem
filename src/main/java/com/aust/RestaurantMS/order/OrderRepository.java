/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.order;

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
public interface OrderRepository extends JpaRepository<Order,Long>{
    @Query(value="SELECT * FROM orderDetails",nativeQuery=true)
    List<Order> orders();
    @Modifying
    @Query(value="UPDATE orderDetails SET status=?2 WHERE orderID=?1",nativeQuery=true)
    void update(Long id,String status);
    @Query(value="SELECT * FROM orderDetails WHERE customer_id=?1",nativeQuery=true)
    List<Order> customerOrders(String id);
}
