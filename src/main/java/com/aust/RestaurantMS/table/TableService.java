/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.table;

import com.aust.RestaurantMS.config.Config;
import com.aust.RestaurantMS.config.ConfigRepository;
import com.aust.RestaurantMS.dto.TableAdRequest;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
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
    @Autowired
    private ConfigRepository configRepo;
    
    protected List<TableDetails> findAll(){
        return tableRepository.findAll();
    }
    @Transactional
    protected TableDetails create(TableAdRequest params){
        return tableRepository.save(new TableDetails(generateId(params.getLocation()),Integer.parseInt(params.getChairs()),"Available"));
    
    }
    @Transactional
    protected void updateStatus(String id,String status){
        tableRepository.updateStatus(id, status);
    }
    protected List<TableDetails> getStatus(String status){
        return tableRepository.status(status);
    }  
    protected TableAdRequest getTDetails(String id){
       TableDetails tds=tableRepository.getReferenceById(id);
       return new TableAdRequest(tds.getTableno(),String.valueOf(tds.getChairs()),String.valueOf(tds.getReservation()),tds.getStatus());
    //the string for reservation might be too long//check in future
    }
    private String generateId(String pos){  
       Optional<Config> opt=configRepo.findById("table");
       if(opt.isPresent()){
           Config config=opt.get();
           int val=Integer.parseInt(config.getValue())+1;
           configRepo.updateVal("table",String.valueOf(val));
           return "111"+String.valueOf(Math.round(10*Math.random()))+String.valueOf(Math.round(10*Math.random()))+String.valueOf(val).concat(pos.substring(0,1));
       }
       else{return null;}
    } 
        
}
