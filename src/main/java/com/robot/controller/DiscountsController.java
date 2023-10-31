package com.robot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dao.DiscountsDAO;
import com.robot.dao.DiscountsDetailDAO;
import com.robot.db.model.Discount;
import com.robot.dto.DiscountsDTO;
import com.robot.repo.DiscountsDetailRepository;
import com.robot.repo.DiscountsRepository;
import com.robot.service.DiscountsService;

@RestController
public class DiscountsController {
	
	@Autowired
	DiscountsService discountsService;
	
	@Autowired
	DiscountsRepository discountsRepository;
	
	@Autowired
	DiscountsDetailRepository detailRepository;
	
	@GetMapping("/api/discounts")
	public DiscountsDTO getDiscount(@RequestParam String id) {
		return discountsService.getDiscount(id);
	}
	
	@GetMapping("/api/discountsOrder")
	public boolean saveDiscountOrder(@RequestBody DiscountsDAO ddao) {
		List<DiscountsDetailDAO> dd = ddao.getData();
		for(DiscountsDetailDAO dda : dd) {
			String dcName = dda.getName();
			if(dcName.equals("Retail") || dcName.equals("Semi Grossir") || dcName.equals("Grossir")) {
				
			}else {
				Discount dsc = discountsRepository.findBydiscountName(dda.getName());				
			}
			
		}
		
		return true;
	}
	
}
