package ar.edu.unju.fi.soo.model.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.dao.PlanDAO;

@Repository
public class PlanDAOImpl extends BaseHibernate<Plan, Long> implements PlanDAO {

}
