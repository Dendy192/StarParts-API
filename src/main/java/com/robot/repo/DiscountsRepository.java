package com.robot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.Discount;

@Repository
public interface DiscountsRepository extends JpaRepository<Discount, String> {

}
