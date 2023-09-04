package com.robot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
