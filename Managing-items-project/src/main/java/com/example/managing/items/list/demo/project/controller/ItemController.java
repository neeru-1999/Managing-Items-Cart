package com.example.managing.items.list.demo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.managing.items.list.demo.project.entity.Item;
import com.example.managing.items.list.demo.project.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	//handler method to handle list items and return model and view
	@GetMapping("/items")
	public String listItems(Model model) {
		model.addAttribute("TotalItems", itemService.getAllItems());
		return "ItemsViewPage";
		
	}
	@GetMapping("/items/new")
	public String createItemPage(Model model) {
		
		//create item object to hold item page data
		Item item=new Item();
		model.addAttribute("item", item);
		return "Create-Item";

	}
	@PostMapping("/items")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}
	@GetMapping("/items/edit/{id}")
	public String editItemPage(@PathVariable int id,Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "edit-Item";
	}
	
	//handler method to handle edit_student template
	
	@PostMapping("/items/{id}")
	public String updateItem(@PathVariable int id,
			@ModelAttribute("item") Item item,
	        Model model){
	      
		//get Item from database by id
		Item existingItem=itemService.getItemById(id);
		//existingItem.setId(id);
		existingItem.setName(item.getName());
		existingItem.setPrice(item.getPrice());
		existingItem.setQuantity(item.getQuantity());
	      
		//save updated item object
		itemService.updateItem(existingItem);
		return "redirect:/items";  	
	 }
	
	//handler method to handle delete item request
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable int id) {
		itemService.deleteItemById(id);
		return "redirect:/items";
	}
	
	@GetMapping("/items/final")
	public String confirmOrder() {
		return "Confirm-order";
	}

}
