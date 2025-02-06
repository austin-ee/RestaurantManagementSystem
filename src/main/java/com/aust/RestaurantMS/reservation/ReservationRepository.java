/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.reservation;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    @Query(value="SELECT * FROM reservation WHERE user_id=?1 and status=?2",nativeQuery=true)
    List<Reservation> myresevations(String id,String tp);
    @Query(value="UPDATE reservation SET status=?2 WHERE reservationId=?1",nativeQuery=true)
    void update(Long id,String status);
}
