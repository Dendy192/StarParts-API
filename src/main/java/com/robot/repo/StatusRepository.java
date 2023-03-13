package com.robot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.StatusOutlet;


@Repository
public interface StatusRepository extends JpaRepository<StatusOutlet, Integer> {
//	Optional<StatusOutlet> findById(Integer id);
}
