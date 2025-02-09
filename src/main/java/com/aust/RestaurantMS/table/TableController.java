/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.table;

import com.aust.RestaurantMS.dto.TableAdRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steve
 */
@RestController
@RequestMapping("aust/api/table")
public class TableController {
    @Autowired
    private TableService tableService;
        
    @GetMapping
    public List<TableDetails> tables(){
        return tableService.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addTable(@RequestBody TableAdRequest params){
        if(tableService.create(params)!=null){
            return ResponseEntity.ok().body("Operation Successful");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Operation Not Successful");
        }
    }
    @PostMapping("/stat")
    public List<TableDetails> tableStat(@RequestParam("check") String status){
      return tableService.getStatus(status);
    }
    @PostMapping("/tdet")
    public TableAdRequest table(@RequestParam("table") String id){
        return tableService.getTDetails(id);
    }
}
