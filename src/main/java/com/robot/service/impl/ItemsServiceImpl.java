package com.robot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.db.model.Items;
import com.robot.dto.items.ItemsDTO;
import com.robot.dto.items.ItemsDTOData;
import com.robot.repo.ItemsRepository;
import com.robot.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	ItemsRepository itemsRepository;
	
	@Override
	public ItemsDTO findByBrand(String brand) {
		// TODO Auto-generated method stub
		String itemID = "";
		String itemName = "";
		String itemBrand = "";
		String itemJenis = "";
		String itemSubJenis = "";
		Double itemPrice = 0.0;
		String itemIsActive = "";
		boolean status = false;
		List<ItemsDTOData> ld = new ArrayList<>();
		
		System.out.println("masuk ke sini ga");
		List<Items> items = itemsRepository.findByitemBrandAndItemIsActive(brand, "Y");
//		List<Items> item = itemsRepository.FindItem(brand, "Y");
		if(items != null) {
			for(Items item: items) {
//			System.out.println(item);
			itemID = item.getItemID();
			itemName = item.getItemName();
			itemBrand = item.getItemBrand();
			itemSubJenis =  item.getItemSubJenis();
			itemJenis = item.getItemJenis();
			itemPrice = item.getItemPrice();
			status = true;
			ItemsDTOData data = new ItemsDTOData(itemID, itemName, itemBrand, itemSubJenis, itemJenis, itemPrice);
			ld.add(data);
			}
		}else {
			ItemsDTOData data = new ItemsDTOData(itemID, itemName, itemBrand, itemSubJenis, itemJenis, itemPrice);
			ld.add(data);
		}
		ItemsDTO dto = new ItemsDTO();
		dto.setSuccess(status);
		dto.setData(ld);
		return dto;
	}

}
