/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aust.RestaurantMS.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface ConfigRepository extends JpaRepository<Config,String>{
    @Modifying
    @Query(value="UPDATE config SET value=?2 WHERE name=?1",nativeQuery=true)
    void updateVal(String key,String val);
}
