package com.robot.service;

import java.util.List;
import java.util.Optional;

import com.robot.dto.OutletDTO;
import com.robot.dto.OutletDTOData;


public interface OutletService {

	OutletDTOData findByPhone(String phone);
//	List<Outlet> findAllOutlet();
//	Optional<Outlet> findById(String id);
//	Outlet saveOutlet(Outlet outlet);
//	List<OutletDTO> findByPhone(String phone);
//	Outlet updateEmpl
}
