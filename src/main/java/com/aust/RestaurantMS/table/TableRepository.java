/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.table;

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
public interface TableRepository extends JpaRepository<TableDetails,String> {
    @Query(value="SELECT * from table_details where status=?1",nativeQuery=true)
    List<TableDetails> findAvailable(String stat);
    @Modifying
    @Query(value="UPDATE table_details SET status=?2 WHERE tableno=?1",nativeQuery=true)
    void updateStatus(String id,String status);
    @Query(value="SELECT * from table_details WHERE status=?1",nativeQuery=true)
    List<TableDetails> status(String status);
}
