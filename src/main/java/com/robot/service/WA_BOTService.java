package com.robot.service;


import com.robot.dto.WA_BOTDTO;


public interface WA_BOTService {
	WA_BOTDTO findByPhone(String phone);
}
