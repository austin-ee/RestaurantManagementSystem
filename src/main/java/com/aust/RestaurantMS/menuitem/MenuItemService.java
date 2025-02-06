/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.menuitem;

import com.aust.RestaurantMS.dto.ItemRequest;
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
    protected MenuItem add(ItemRequest params){
        return menuItemRepository.save(new MenuItem(12121313L,params.getObj(),params.getTime(),params.getChildren(),
        Integer.parseInt(params.getValue())));
    }
    protected void remove(String i){
       menuItemRepository.delete(menuItemRepository.getReferenceById(Long.parseLong(i)));
    }
    protected void update(ItemRequest params){
        menuItemRepository.updateItem(Long.parseLong(params.getMenuid()), params.getChildren(),params.getTime(),params.getValue());
    }
    protected List<MenuItem> typeItems(String time){
        return menuItemRepository.typeMenu(time);
    }
    protected MenuItem itemDetails(String id){
        return menuItemRepository.getReferenceById(Long.parseLong(id));
    }
}
