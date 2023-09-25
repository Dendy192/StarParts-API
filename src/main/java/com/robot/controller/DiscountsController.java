package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dto.DiscountsDTO;
import com.robot.service.DiscountsService;

@RestController
public class DiscountsController {
	
	@Autowired
	DiscountsService discountsService;
	
	@GetMapping("/api/discounts")
	public DiscountsDTO getDiscount(@RequestParam String id) {
		return discountsService.getDiscount(id);
	}
}
