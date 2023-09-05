package com.robot.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.db.model.StatusOutlet;
import com.robot.db.model.WA_BOT;
import com.robot.dto.WA_BOTDTO;
import com.robot.dto.WA_BOTDTOData;
import com.robot.repo.StatusRepository;
import com.robot.repo.WA_BOTRepository;
import com.robot.service.StatusOutletService;
import com.robot.service.WA_BOTService;

@Service
public class WA_BOTServiceImpl implements WA_BOTService {
	
	@Autowired
	WA_BOTRepository waBotRepository;
	
	@Autowired
	StatusRepository statusRepository;

	@Override
	public WA_BOTDTO findByPhone(String phone) {
		// TODO Auto-generated method stub
//		WA_BOT wab = waBotRepository.findByBOT_WA_PHONE(phone);
		Optional<WA_BOT> oWab = Optional.of(waBotRepository.findByPhone(phone));
//		System.out.println(oWab);
//		if((wab !=null)) {
//			
//		}
		WA_BOTDTO wabd = new WA_BOTDTO();
		WA_BOTDTOData wabdd = new WA_BOTDTOData();
		String statusMessage = "";
		String status = "";
		boolean success = false;
		if(oWab.isPresent()) {
			System.out.println(oWab);
			WA_BOT wab = oWab.get();
			System.out.println(wab.toString());
			int tmpS = wab.getBOT_WA_STATUS();
			System.out.println(tmpS);
			 StatusOutlet so = statusRepository.findById(tmpS);
			 status = so.getStatus();
			if(status.equals("Active")) {
				success = true;
				statusMessage = "Success";
				wabdd.setId(wab.getBOT_WA_ID());
				wabdd.setName(wab.getBOT_WA_NAME());
				wabdd.setPhone(wab.getBOT_WA_PHONE());
				wabdd.setDiscount(wab.getBOT_WA_DISCOUNT());
				wabdd.setStatus(status);
				wabdd.setType(wab.getBOT_WA_TYPE());
				wabd.setStatus(statusMessage);
				wabd.setSuccess(success);
				wabd.setData(wabdd);
				
				
			}else {
				success = false;
				statusMessage = "Failed ";
				wabdd.setId(wab.getBOT_WA_ID());
				wabdd.setName(wab.getBOT_WA_NAME());
				wabdd.setPhone(wab.getBOT_WA_PHONE());
				wabdd.setPhone(wab.getBOT_WA_DISCOUNT());
				wabdd.setStatus(status);
				wabdd.setType(wab.getBOT_WA_TYPE());
				wabd.setStatus(statusMessage);
				wabd.setSuccess(success);
				wabd.setData(wabdd);
			}
		}else {
			success = false;
			statusMessage = "Failed";
			wabdd.setId("");
			wabdd.setName("");
			wabdd.setPhone("");
			wabdd.setStatus(status);
			wabdd.setType("");
			wabd.setStatus(statusMessage);
			wabd.setSuccess(success);
			wabd.setData(wabdd);
		}
		return wabd;	
	}

	
	
} 
