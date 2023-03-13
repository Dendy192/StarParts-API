package com.robot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.TypeOutlet;


@Repository
public interface TypeRepository extends JpaRepository<TypeOutlet, Integer> {
	Optional<TypeOutlet> findById(Integer id);
}
