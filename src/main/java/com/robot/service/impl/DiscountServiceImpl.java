package com.robot.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.db.model.Discount;
import com.robot.db.model.DiscountsDetail;
import com.robot.db.model.Outlet;
import com.robot.db.model.TypeOutlet;
import com.robot.dto.DiscountsDTO;
import com.robot.dto.DiscountsDTOData;
import com.robot.entity.OutletEntity;
import com.robot.repo.DiscountsDetailRepository;
import com.robot.repo.DiscountsRepository;
import com.robot.repo.OutletRepository;
import com.robot.repo.TypeRepository;
import com.robot.service.DiscountsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class DiscountServiceImpl implements DiscountsService {
	
	private static final Logger log = LoggerFactory.getLogger(DiscountServiceImpl.class);

	@Autowired
	DiscountsRepository discountsRepository;
	
	@Autowired
	DiscountsDetailRepository discountsDetailRepository;
	
	@Autowired
	OutletRepository outletRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	OutletEntity oE;
	
	@Override
	public DiscountsDTO getDiscount(String id) {
		// TODO Auto-generated method stub
		DiscountsDTO ddto = new DiscountsDTO();
		java.util.Date currentDate = new java.util.Date();
		LocalTime currentTime = LocalTime.now();
		List<DiscountsDTOData> lDdtoD = new ArrayList<>();
		Optional<List<Discount>> oLdc =Optional.ofNullable(discountsRepository.findAll());
		boolean status = false;
		Optional<Outlet> ooutlet = outletRepository.findById(id);
		try {
			if(ooutlet.isPresent()) {
				Outlet outlet = ooutlet.get();
				Optional<TypeOutlet> oto = typeRepository.findById(outlet.getType());
				TypeOutlet to = oto.get();
				DiscountsDTOData  ddtod1  = new DiscountsDTOData();
				ddtod1.setName(to.getName());
				ddtod1.setType("Outlet");
				ddtod1.setAmmount(to.getPercen());
				lDdtoD.add(ddtod1);
			}
		if(oLdc.isPresent()) {
			List<Discount> lD = oLdc.get();
//			System.out.println(id);
			for(Discount dc : lD) {
				System.out.println(dc.toString());
				
				if(isValidDateAndTime(dc, currentDate, currentTime)) {
					System.out.println(dc.getDiscountId());
					DiscountsDetail dd = discountsDetailRepository.findBydiscountDetailId(dc.getDiscountId());
//					tambahin validasi nya di sini buat cek misalkan dia per toko misalkan depannya bdg atau 
//					toko tertentu bikin rulesnya
//					System.out.println("masuk sini");
					DiscountsDTOData  ddtod  = new DiscountsDTOData();
					if(dc.getDiscountType().equalsIgnoreCase("outlet")) {
						String sql = "SELECT id, name, email, phone, status FROM Outlet WHERE "+dd.getDiscountDetailRules();
						log.info(sql);
//						System.out.println(lO);
//						System.out.println("msuk sini");
						List<Outlet> lO = oE.findByQuery(sql);
//						System.out.println(lO.toString());
						for(Outlet ol : lO) {
							if(ol.getId().equals(id)) {
								ddtod.setName(dc.getDiscountName());
								ddtod.setType(dc.getDiscountType());
								ddtod.setAmmount(dd.getDiscountDetailAmmount());
								status = true;
								lDdtoD.add(ddtod);
								log.info("Present data");
							}
//				
						}
						
						
					}else {						
						ddtod.setName(dc.getDiscountName());
						ddtod.setType(dd.getDiscountDetailRules());
						ddtod.setAmmount(dd.getDiscountDetailAmmount());
						status = true;
						lDdtoD.add(ddtod);
					}
					
					
				}
				
			}
		
		}
		}catch (Exception e) {
			log.error(e.getMessage());
			// TODO: handle exception
		}
		ddto.setStatus(status);
		ddto.setData(lDdtoD);
		return ddto;
		
	}
	
	private boolean isValidDateAndTime(Discount discount, java.util.Date currentDate, LocalTime time) {
		LocalTime lt1 = discount.getDiscountStartTime().toLocalTime();
		LocalTime lt2 = discount.getDiscountEndTime().toLocalTime();
		int startRes = time.compareTo(lt1);
		int endRes = time.compareTo(lt2);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		int startDateResult = sdf.format(currentDate).compareTo(sdf.format(discount.getDiscountStartDate()));
		int endDateResult = sdf.format(currentDate).compareTo(sdf.format(discount.getDiscountEndDate()));
		System.out.println(startDateResult);
		System.out.println(endDateResult);
		System.out.println(startRes);
		System.out.println(endRes);
		boolean result = false;
		if(startDateResult >= 0 && endDateResult <=0 && startRes >= 0 && endRes <= -1 ) {
			result = true;
		}
//		if(!currentDate.isBefore(discount.getDiscountStartDate()) && 
//				!currentDate.isAfter(discount.getDiscountEndDate()) ||
//				currentDate.equals(discount.getDiscountStartDate()) &&
//				currentDate.equals(discount.getDiscountEndDate()) && 
//				startRes == 1 && 
//				endRes == -1) {
//			result = true;
//		}
		return result;
	}
	

}
