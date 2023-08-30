package com.robot.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.service.ItemsService;
import com.robot.service.OutletService;

import id.git.service.RequestAR;



@RestController
//@RequestMapping("/api")
public class OutletController {
//	private OutletService outletService;
	
	
	@Autowired
	OutletService outletService;
//	
	

//	@GetMapping("/api/outlet")
//	public OutletDTOData findOutletByPhone(@RequestParam String phone){
//		return outletService.findByPhone(phone);
//	}
	
	@GetMapping("/api/AR")
	public String ARservice(@RequestParam String id, @RequestParam String name, @RequestParam String phone) {
		RequestAR ar = new RequestAR();
		String result = ar.request(id, name, phone);
		return result;
	}
	
	
//	public OutletController(OutletService outletService, OutletRepository outletRepository) {
//		super();
//		this.outletService = outletService;
//		this.outletRepository = outletRepository;
//	}

//
//	@GetMapping()
//	public List<Outlet> findAllOutlet(){
//		return outletService.findAllOutlet();
//	}
//	
//	@GetMapping("/outlet")
//	public <List<Outlet>> getOutletByPhone(@RequestParam String phone){
//		return new ResponseEntity<List<Outlet>>(outletRepository.findByPhone(phone), HttpStatus.OK);
//	}
//	@GetMapping("/{id}")
//	public Optional<Outlet> findOutletById(@PathVariable("id") String id){
//		return outletService.findById(id);
//	}
	
//	@RequestMapping(path = "/outlet", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
//	public List<Outlet> findByPhone(@RequestParam(name = "phone") String phone){
//		return outletRepository.findByPhone(phone);
//	}
//	
	
	
}
