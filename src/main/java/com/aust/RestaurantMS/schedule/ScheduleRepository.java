/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.schedule;

import java.time.LocalDate;
import java.time.LocalTime;
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
public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
    @Query(value="SELECT user_id,date,shift_start,shift_end FROM schedule",nativeQuery=true)
    List<Schedule> findAllS();
    @Query(value="SELECT * FROM schedule WHERE user_id=?1",nativeQuery=true)
    List<Schedule> empSchedule(String id);
    @Modifying
    @Query(value="UPDATE schedule SET date=?2,shiftstart=?3,shiftend=?4,user_id=?5 WHERE sheduleID=?1",nativeQuery=true)
    void update(Long id,LocalDate date,LocalTime start,LocalTime end,String empid);
    
}
