package com.example.managing.items.list.demo.project.service;

import java.util.List;

import com.example.managing.items.list.demo.project.entity.Item;

public interface ItemService {
	
	List<Item> getAllItems();
    public Item saveItem(Item item);
    
    Item getItemById(int id);
    Item updateItem(Item item);
    
    void deleteItemById(int id);

}
