package com.robot.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.robot.db.model.Outlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class OutletEntity {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Outlet> findByQuery(String sql) {
		System.out.println(sql);
		// List<Outlet> outlet = new ArrayList<>();
		TypedQuery<Outlet> query = entityManager.createQuery(sql, Outlet.class);
		List<Outlet> result = query.getResultList();
		// for (Outlet oc : result) {
		// Outlet ot = new Outlet();
		// ot.setId((String) oc[0]);
		// ot.setName((String) oc[1]);
		// ot.setEmail((String) oc[2]);
		// ot.setPhone((String) oc[3]);
		// ot.setStatus((int) oc[4]);
		// outlet.add(ot);
		// }
		// return outlet;
		return result;
	}

}
