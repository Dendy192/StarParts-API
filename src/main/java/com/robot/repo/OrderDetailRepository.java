package com.robot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.OrderDetail;

@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> findByOrderId(String orderId);

}
