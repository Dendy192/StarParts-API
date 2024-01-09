package com.robot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.robot.db.model.Outlet;
import com.robot.repo.costum.OutletRepositoryCustom;

@Repository
// @EnableJpaRepositories
public interface OutletRepository extends JpaRepository<Outlet, String>, OutletRepositoryCustom {

	// @Query("SELECT new test.controller.OutletDTO(so.\"OUTLET_ID\",
	// so.\"OUTLET_NAME\", so.\"OUTLET_PHONE\",ss.\"STATUS_NAME\",
	// stc.\"TYPE_NAME\", stc.\"TYPE_PERCENTAGE\") "
	// +"FROM \"SP_OUTLET\" so "
	// + "INNER JOIN \"SP_STATUS\" ss ON so.\"OUTLET_STATUS\" = ss.\"ID_STATUS\" "
	// + "INNER JOIN \"SP_TYPE_CUSTOMER\" stc ON so.\"OUTLET_TYPE\" =
	// stc.\"ID_TYPE_CUSTOMER\" "
	// + "WHERE \"OUTLET_PHONE\" = ?1")
	// Outlet findByPhone(String phone);
	Outlet findByPhone(String phone);

	// @Query("SELECT o FROM Outlet o WHERE ")
	// List<Outlet> findByQuery();
	// Outlet findById (String id);

}
