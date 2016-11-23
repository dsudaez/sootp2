package ar.edu.unju.fi.soo.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Plan7030;
import ar.edu.unju.fi.soo.model.dao.PlanDAO;

@Repository
public class PlanDAOImpl extends BaseHibernate<Plan, Long> implements PlanDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findAllByClientName(String clientName) {
		Criteria criteria = createCriteria();
		criteria.createAlias("client", "client");
		criteria.add(Restrictions.eq("client.name", clientName));
//		criteria.setMaxResults(1);
//		return (Plan) criteria.uniqueResult();
		return criteria.list();
	}

	@Override
	public void payNextFee(long id) {
		Criteria criteria = createCriteria();
		criteria.createAlias("plan", "plan");
		criteria.add(Restrictions.eq("plan.id",id));
		Plan plan = (Plan) criteria.list();
		for (Fee fee : plan.getFees()){
			if (!fee.isPaid()){
				fee.pay();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findAllByClientDNI(String planType, String clientDNI) {
		Criteria criteria = createCriteria();
//		getSession().createCriteria(Plan7030.class);
		criteria.createAlias("client", "client");
		criteria.add(Restrictions.eq("client.dni", clientDNI));
		if (planType!=null) {
//			getSession().createCriteria(Plan7030.class);

			criteria.add(Restrictions.eq("class",planType));
		}
		
		return criteria.list();
	}

}
