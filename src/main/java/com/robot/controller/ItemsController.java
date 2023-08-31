package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dto.ItemsDTO;
import com.robot.service.ItemsService;

@RestController
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@GetMapping("/api/item")
	public ItemsDTO getItem(@RequestParam String brand, @RequestParam String jenis) {
		return itemsService.findByBrand(brand, jenis);
	}
	
	@GetMapping("/api/items")
	public ItemsDTO getAllItem() {
		return itemsService.findByAll();
	}
}
