package com.robot.service;

import com.robot.dto.UserDTO;

public interface UserService {
	
	UserDTO findUser(String phone);

}
