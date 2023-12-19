package com.robot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
	List<Order> findByCustomerIdAndStatus(String customerId, String status);
	List<Order> findByCustomerId(String customerId);
	List<Order> findByStatus(String status);
}
