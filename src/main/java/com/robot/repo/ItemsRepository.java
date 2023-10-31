package com.robot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.robot.db.model.Items;
import com.robot.repo.costum.ItemRepositoryCustom;

@Repository
public interface ItemsRepository extends JpaRepository<Items, String>,ItemRepositoryCustom {
	
	List<Items> findByitemBrandAndItemIsActive(String brand, String status);
	
	
	
//	List<Items> findByitemBrandAnditemJenisAnditemStockAndItemIsActive(String brand,String jenis, int stock, String status);
}
