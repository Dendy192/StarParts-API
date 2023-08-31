package com.robot.repo.costum;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.robot.db.model.Items;

public interface tes {
//	@Query(value = " SELECT \"ITEM_ID\", \"ITEM_NAME\", \"ITEM_BRAND\", \"ITEM_SUB_BRAND\","
//			+ "\"ITEM_SUB_ITEM\", \"ITEM_JENIS\", \"ITEM_SUB_JENIS\", \"ITEM_UKURAN\","
//			+ "\"ITEM_PRICE\", \"ITEM_STOCK\", \"ITEM_IS_ACTIVE\" "
//			+ "FROM \"SP_ITEMS\" WHERE \"ITEM_BRAND\" = :brand AND \"ITEM_IS_ACTIVE\" = :status" , nativeQuery = true)
//	List<Items> FindItem(@Param("brand")String itemBrand, @Param("status")String itemIsActive);
	
//	@Query(value = "SELECT * FROM \"SP_ITEMS\" WHERE \"ITEM_BRAND\" = ?1 AND \"ITEM_JENIS\" = ?2 AND \"ITEM_STOCK\" != ?3 AND \"ITEM_IS_ACTIVE\" = ?4")
	@Query(value = "FROM Items WHERE itemBrand = ?1 AND itemJenis = ?2 AND itemStock != ?3 AND itemIsActive = ?4 ORDER BY itemSubJenis")
	List<Items> findItem (String brand,String jenis, int stock, String status);
}
