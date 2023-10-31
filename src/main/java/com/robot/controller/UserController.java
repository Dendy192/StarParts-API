package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dto.UserDTO;
import com.robot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	public UserDTO getUser(@RequestParam String phone) {
		return userService.findUser(phone);
	}
}
