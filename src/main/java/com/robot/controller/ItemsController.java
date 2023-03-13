package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dto.items.ItemsDTO;
import com.robot.service.ItemsService;

@RestController
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@GetMapping("/api/items")
	public ItemsDTO getAllItem(@RequestParam String brand) {
		return itemsService.findByBrand(brand);
	}
}
