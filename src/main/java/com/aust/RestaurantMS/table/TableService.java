/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.table;

import com.aust.RestaurantMS.dto.TableAdRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;
    
    public List<TableDetails> findAvailable(String status){
        return tableRepository.findAvailable(status);
    }
    protected TableDetails create(TableAdRequest params){
        return tableRepository.save(new TableDetails(1002L,Integer.parseInt(params.getChairs()),"Available"));
    
    }
        
}
