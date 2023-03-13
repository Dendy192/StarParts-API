package com.robot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.robot.db.model.Outlet;
import com.robot.db.model.StatusOutlet;
import com.robot.db.model.TypeOutlet;
import com.robot.dto.Outlet.OutletDTO;
import com.robot.dto.Outlet.OutletDTOData;
import com.robot.dto.Outlet.OutletDTOStatus;
import com.robot.repo.OutletRepository;
import com.robot.repo.StatusRepository;
import com.robot.repo.TypeRepository;
import com.robot.service.OutletService;


@Service
public class OutletServiceImpl implements OutletService{

	@Autowired
	private OutletRepository outletRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	TypeRepository typeRepository;


	@Override
	public OutletDTOData findByPhone(String phone) {
		// TODO Auto-generated method 
		Outlet ot = outletRepository.findByPhone(phone);
		StatusOutlet so = null;
		TypeOutlet to = null;
		OutletDTOStatus ods = new OutletDTOStatus();
		String id ="";
		String name = "";
		String phoneO = "";
		String status ="";
		String tName  ="";
		int p = 0;
		boolean msg = false;
		if(!(ot == null)) {
			
		msg = true;
//		List<OutletDTO> test = new ArrayList<>();
		int idStatus =ot.getStatus(); 
		int idType = ot.getType();
//		Optional<StatusOutlet> oSo = statusRepository.findById(idStatus);
//		if(oSo.isPresent()) {
		 so = statusRepository.getById(idStatus);
		 to = typeRepository.getById(idType);
		int per = ot.getPercentage();
		if(per ==0) {
			per = to.getPercen();
			}
		id = ot.getId();
		name = ot.getName();
		phoneO = phone;
		status = so.getStatus();
		tName = to.getName();
		p = per;
		}
		OutletDTO odDto = new OutletDTO(id, name, phoneO, status,tName, p );
		ods.setData(odDto);
		ods.setSuccess(msg);
		OutletDTOData dd = new OutletDTOData(ods);
		return dd;
	}

	
	
//	public OutletServiceImp(OutletRepository outletRepository) {
//		this.outletRepository = outletRepository;
//	}

//	@Override
//	public List<Outlet> findAllOutlet() {
//		// TODO Auto-generated method stub
//		return outletRepository.findAll();
//	}
//
//	@Override
//	public Optional<Outlet> findById(String id) {
//		// TODO Auto-generated method stub
//		return outletRepository.findById(id);
//	}
//
//	@Override
//	public Outlet saveOutlet(Outlet outlet) {
//		// TODO Auto-generated method stub
//		return outletRepository.save(outlet);
//	}

//	@Override
//	public List<Outlet> findByPhoneOutlets(String phone) {
//		// TODO Auto-generated method stub
//				return outletRepository.find;
//	}

	
	

	
	

}
