package com.robot.service;

import com.robot.dto.ItemsDTO;

public interface ItemsService {
	ItemsDTO findByBrand(String brand, String jenis);
	ItemsDTO findByAll();
	
	
}
