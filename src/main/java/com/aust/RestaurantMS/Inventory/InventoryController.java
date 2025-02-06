/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.Inventory;

import com.aust.RestaurantMS.dto.ItemAdRequest;
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
@RequestMapping("aust/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    
    @GetMapping
    public List<Inventory> inventoryIts(){
        return inventoryService.inventory();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemAdRequest params){
        if(inventoryService.create(params)!=null){
            return ResponseEntity.ok().body("Operation Successful");
        }
        else{return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Operation Not Successful");}
    }
    @PostMapping("/get")
    public ResponseEntity<?> getItem(@RequestBody String param){
        if(param !=null){String[]args=param.split(":");
          int val=inventoryService.removeItem(Long.parseLong(args[0]),Integer.parseInt(args[1]));
          return (val<Integer.parseInt(args[1]))?ResponseEntity.ok().body("Removed "+val+" "+args[0]+" Remaining amount:"+val):ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Operation Not Successful");
        }
        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body("Item Details Required");
    }
    @PostMapping("/ics")
    public ResponseEntity<?> increase(@RequestBody String param){
        if(param !=null){String[]args=param.split(":");
          int val=inventoryService.addItem(Long.parseLong(args[0]),Integer.parseInt(args[1]));
          return (val<Integer.parseInt(args[1]))?ResponseEntity.ok().body("Increased "+args[0]+"  by "+args[1]+" Remaining amount:"+val):ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Operation Not Successful");
        }
        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body("Item Details Required");
    }
    @PostMapping("/det")
    public Inventory itemDetails(@RequestParam("item") String entry){
       return inventoryService.inventoryItemDet(entry);
    }
        
}
