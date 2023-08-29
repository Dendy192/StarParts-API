package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dto.WA_BOTDTO;
import com.robot.service.WA_BOTService;

@RestController
public class BOT_WAController {
	@Autowired
	WA_BOTService wa_BOTService;
	
	@GetMapping("/api/user")
	public WA_BOTDTO getUser(@RequestParam String phone) {
		System.out.println(phone);
		return wa_BOTService.findByPhone(phone);
	}
}
