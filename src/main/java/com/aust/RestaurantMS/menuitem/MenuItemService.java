/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.menuitem;

import com.aust.RestaurantMS.dto.MenuItemRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    protected List<MenuItem> allItems(){
        return menuItemRepository.findAll();
    }
    protected MenuItem add(MenuItemRequest params){
        return menuItemRepository.save(new MenuItem(generateId(params.getTime()),params.getObj(),params.getTime(),params.getChildren(),
        Integer.parseInt(params.getValue())));
    }
    protected void remove(String i){
       menuItemRepository.delete(menuItemRepository.getReferenceById(i));
    }
    protected void update(MenuItemRequest params){
        menuItemRepository.updateItem(params.getMenuid(), params.getChildren(),params.getTime(),params.getValue());
    }
    protected List<MenuItem> typeItems(String time){
        return menuItemRepository.typeMenu(time);
    }
    protected MenuItem itemDetails(String id){
        return menuItemRepository.getReferenceById(id);
    }
     private String generateId(String type){
       LocalDate dt=LocalDate.now();
       LocalTime tm=LocalTime.now();
       String y=type.substring(0, 2)+String.valueOf(dt.getYear()).substring(2)+dt.getMonthValue()+dt.getDayOfMonth()+tm.getHour()+tm.getMinute()+String.valueOf(Math.round(10*Math.random()));
       return y;
    } 
}
