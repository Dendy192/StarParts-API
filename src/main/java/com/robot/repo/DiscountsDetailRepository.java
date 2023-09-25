package com.robot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.DiscountsDetail;

@Repository
public interface DiscountsDetailRepository extends JpaRepository<DiscountsDetail, Integer> {
	
	DiscountsDetail findBydiscountDetailId (String id);

}
