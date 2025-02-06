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
    
    protected List<TableDetails> findAll(){
        return tableRepository.findAll();
    }
    protected TableDetails create(TableAdRequest params){
        return tableRepository.save(new TableDetails(1002L,Integer.parseInt(params.getChairs()),"Available"));
    
    }
    protected void updateStatus(Long id,String status){
        tableRepository.updateStatus(id, status);
    }
    protected List<TableDetails> getStatus(String status){
        return tableRepository.status(status);
    }  
    protected TableDetails getTDetails(Long id){
       return tableRepository.getReferenceById(id);
    }
        
}
