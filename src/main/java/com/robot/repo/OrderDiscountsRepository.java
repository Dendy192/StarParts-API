package com.robot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.OrderDiscounts;

@Repository
public interface OrderDiscountsRepository extends JpaRepository<OrderDiscounts, Integer>{

}
