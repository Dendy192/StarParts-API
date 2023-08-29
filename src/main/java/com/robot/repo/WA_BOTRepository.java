package com.robot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.db.model.WA_BOT;


@Repository
public interface WA_BOTRepository extends JpaRepository<WA_BOT, String> {

	WA_BOT findByPhone(String bOT_WA_PHONE);
	
}
