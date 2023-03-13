package com.robot.service;

import com.robot.dto.items.ItemsDTO;

public interface ItemsService {
	ItemsDTO findByBrand(String brand);
}
