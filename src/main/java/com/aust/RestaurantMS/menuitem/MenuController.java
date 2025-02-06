/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.menuitem;

import com.aust.RestaurantMS.dto.ItemRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/aust/api/menu")
public class MenuController {
    @Autowired
    private MenuItemService menuService;
    
    @GetMapping
    public List<MenuItem> menu(){
      return menuService.allItems();
    }
    @PostMapping("/add")
    public ResponseEntity<?> adjust(@RequestBody ItemRequest params){
       return (menuService.add(params)!=null)?ResponseEntity.ok().body("Added Successfully"):ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Operation failed");
    }
    @DeleteMapping("/del") 
    public void removeMenuItem(@RequestParam("value") String item){
        menuService.remove(item);
    }
    @PostMapping("/upt")
    public void update(@RequestBody ItemRequest params){
        menuService.update(params);
    }
    @PostMapping("/det")
    public MenuItem detaild(@RequestParam String item){
        return menuService.itemDetails(item);
    }
    @PostMapping("/type")
    public List<MenuItem> timeMenu(@RequestParam("time") String when){
        return menuService.typeItems(when);
    }
}
