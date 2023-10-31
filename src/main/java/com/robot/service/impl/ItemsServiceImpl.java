package com.robot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.db.model.Items;
import com.robot.dto.ItemsDTO;
import com.robot.dto.ItemsDTOData;
import com.robot.repo.ItemsRepository;
import com.robot.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	ItemsRepository itemsRepository;
	
	
	
	@Override
	public ItemsDTO findByBrand(String brand, String jenis) {
		// TODO Auto-generated method stub
		String itemID = "";
		String itemName = "";
		String itemBrand = "";
		String itemJenis = "";
		String itemSubJenis = "";
		Double itemPrice = 0.0;
		String itemIsActive = "";
		String itemUkuruan = "";
		boolean status = false;
		List<ItemsDTOData> ld = new ArrayList<>();
		
		System.out.println("masuk ke sini ga");
//		List<Items> items = itemsRepository.findByitemBrandAndItemIsActive(brand, "Y");
//		List<Items> item = itemsRepository.FindItem(brand, "Y");
		Optional<List<Items>> oItems = null;
		if (brand.equals("FDR")) {
			oItems = Optional.ofNullable(itemsRepository.findItemFDR(brand, jenis, 0, "Y"));
		}else {
			oItems = Optional.ofNullable(itemsRepository.findItemOSRAM(brand, jenis, 0, "Y"));
		}
		
		if(oItems.isPresent()) {
			List<Items> items = oItems.get();
			for(Items item: items) {
//			System.out.println(item);
//				System.out.println();
			if(item.getItemBrand().equals("FDR")) {
				itemBrand = item.getItemBrand();
			}else if(item.getItemBrand().equals("OSRAM")) {
				itemBrand = item.getItemSubBrand();
			}
			itemID = item.getItemID();
			itemName = item.getItemName();
			itemSubJenis =  item.getItemSubJenis();
			itemUkuruan = item.getItemUkuran();
			itemJenis = item.getItemJenis();
			itemPrice = item.getItemPrice();
//			System.out.println(itemSubJenis);
			status = true;
			ItemsDTOData data = new ItemsDTOData(itemID, itemName, itemBrand, itemSubJenis,itemUkuruan, itemJenis, itemPrice);
			ld.add(data);
			}
		}else {
			ItemsDTOData data = new ItemsDTOData(itemID, itemName, itemBrand, itemSubJenis,itemUkuruan, itemJenis, itemPrice);
			ld.add(data);
		}
		ItemsDTO dto = new ItemsDTO();
		dto.setSuccess(status);
		dto.setData(ld);
		return dto;
	}



	@Override
	public ItemsDTO findByAll() {
		// TODO Auto-generated method stub
		String itemID = "";
		String itemName = "";
		String itemBrand = "";
		String itemJenis = "";
		String itemSubJenis = "";
		Double itemPrice = 0.0;
		String itemIsActive = "";
		String itemUkuruan = "";
		boolean status = false;
		List<ItemsDTOData> ld = new ArrayList<>();
		
		System.out.println("masuk ke sini ga");
//		List<Items> items = itemsRepository.findByitemBrandAndItemIsActive(brand, "Y");
//		List<Items> item = itemsRepository.FindItem(brand, "Y");
		
			List<Items> items = itemsRepository.findAll();
			for(Items item: items) {
//			System.out.println(item);
			itemID = item.getItemID();
			itemName = item.getItemName();
			if(item.getItemBrand().equals("FDR")) {
				itemBrand = item.getItemBrand();
			}else if(item.getItemBrand().equals("OSRAM")) {
				itemBrand = item.getItemSubBrand();
			}
			
			itemSubJenis =  item.getItemSubJenis();
			itemUkuruan = item.getItemUkuran();
			itemJenis = item.getItemJenis();
			itemPrice = item.getItemPrice();
			status = true;
			ItemsDTOData data = new ItemsDTOData(itemID, itemName, itemBrand, itemSubJenis,itemUkuruan, itemJenis, itemPrice);
			ld.add(data);
			}
		
		ItemsDTO dto = new ItemsDTO();
		dto.setSuccess(status);
		dto.setData(ld);
		return dto;
	}

}
