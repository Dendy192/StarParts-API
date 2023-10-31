package com.robot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.db.model.Outlet;
import com.robot.db.model.Sales;
import com.robot.dto.UserDTO;
import com.robot.dto.UserDTOData;
import com.robot.repo.OutletRepository;
import com.robot.repo.SalesRepository;
import com.robot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SalesRepository salesRepository;
	
	@Autowired
	private OutletRepository outletRepository;
	
	@Override
	public UserDTO findUser(String phone) {
		// TODO Auto-generated method stub
		boolean status = false;
		String Message = "";
		System.out.println(phone);
		Optional<Sales> oSales = Optional.ofNullable(salesRepository.findByPhone(phone));
		Optional<Outlet> oOutlet = Optional.ofNullable(outletRepository.findByPhone(phone));
		UserDTO udto = new UserDTO();
		
		UserDTOData udtod = new UserDTOData();
		System.out.println(oSales);
		if(oSales.isPresent()) {
			status = true;
			Message = "success";
			Sales sales = oSales.get();
			udtod.setId(sales.getId());
			udtod.setName(sales.getName());
			udtod.setType("Sales");
		}else if(oOutlet.isPresent()) {
			status = true;
			Message = "success";
			Outlet outlet = oOutlet.get();
			udtod.setId(outlet.getId());
			udtod.setName(outlet.getName());
			udtod.setType("Outlet");
		}else {
			status = false;
			Message = "Error";
		}
		udto.setData(udtod);
		udto.setSuccess(status);
		udto.setMessage(Message);
		return udto;
	}

}
