package com.robot.repo.costum;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.robot.db.model.Outlet;


public interface OutletRepositoryCustom {
//	Outlet findByPhone(String phone);
//	@Query("SELECT so.\"OUTLET_ID\", so.\"OUTLET_NAME\", so.\"OUTLET_PHONE\", "
//			+ "ss.\"STATUS_NAME\", stc.\"TYPE_NAME\", stc.\"TYPE_PERCENTAGE\" "
//			+ "FROM \"SP_OUTLET\" so "
//			+ "JOIN \"SP_STATUS\" ss ON so.\"OUTLET_STATUS\" = ss.\"ID_STATUS\" "
//			+ "JOIN \"SP_TYPE_CUSTOMER\" stc ON so.\"OUTLET_TYPE\" = stc.\"ID_TYPE_CUSTOMER\""
//			+ "WHERE \"OUTLET_PHONE\" = ?1")
//	@Query(name = "SELECT * FROM \"SP_OUTLET\" WHERE  :custom", nativeQuery = false)
//	List<Outlet> findOutlet (@RequestParam("custom")String query);
}
