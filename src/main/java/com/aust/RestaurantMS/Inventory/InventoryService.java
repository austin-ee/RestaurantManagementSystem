/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.Inventory;

import com.aust.RestaurantMS.dto.ItemAdRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    
    protected List<Inventory> inventory(){
        return inventoryRepository.findAll();
    }
    protected Inventory create(ItemAdRequest params){
        return inventoryRepository.save(new Inventory(11544L,params.getName(),Integer.parseInt(params.getQuantity()),
        Integer.parseInt(params.getMinQuant()),params.getSinfo()));
    }
    protected int removeItem(Long id,int quant){
        inventoryRepository.getItem(id, (inventoryRepository.itemnumber(id)-quant));
        return inventoryRepository.itemnumber(id);
    }
    protected int addItem(Long id,int quant){
        inventoryRepository.getItem(id, (inventoryRepository.itemnumber(id)+quant));
        return inventoryRepository.itemnumber(id);
    }
    protected Inventory inventoryItemDet(String id){
        return inventoryRepository.getReferenceById(Long.parseLong(id));
    }
}
