package com.robot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.StatusOutlet;
import java.util.List;



@Repository
public interface StatusRepository extends JpaRepository<StatusOutlet, Integer> {
//	StatusOutlet findById(Integer id);
	
	StatusOutlet findById(int id);
}
