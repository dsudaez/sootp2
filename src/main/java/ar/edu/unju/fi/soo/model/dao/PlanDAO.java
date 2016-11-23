package ar.edu.unju.fi.soo.model.dao;

import java.util.List;

import ar.edu.unju.fi.soo.model.Plan;

public interface PlanDAO extends BaseDAO<Plan, Long> {

	List<Plan> findAllByClientName(String clientName);
	
	void payNextFee(long id);
}
