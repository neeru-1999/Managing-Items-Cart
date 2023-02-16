package com.example.managing.items.list.demo.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.managing.items.list.demo.project.entity.Item;
import com.example.managing.items.list.demo.project.repository.ItemRepository;
import com.example.managing.items.list.demo.project.service.ItemService;

@Service
public class ItemServiceImplementation implements ItemService{
	
private ItemRepository itemRepository;
	
    
	public ItemServiceImplementation(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	@Override
	public List<Item> getAllItems() {
		
		return itemRepository.findAll();
	}
	@Override
	public Item saveItem(Item item) {
		
		return itemRepository.save(item);
	}
	@Override
	public Item getItemById(int id) {
		
		return itemRepository.findById(id).get();
	}
	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}
	@Override
	public void deleteItemById(int id) {
		
		 itemRepository.deleteById(id);
		
	}

}
