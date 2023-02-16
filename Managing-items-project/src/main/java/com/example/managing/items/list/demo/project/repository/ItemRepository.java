package com.example.managing.items.list.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managing.items.list.demo.project.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	
}
