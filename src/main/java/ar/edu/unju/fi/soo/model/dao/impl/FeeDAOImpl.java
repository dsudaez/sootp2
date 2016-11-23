package ar.edu.unju.fi.soo.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.dao.FeeDAO;

@Repository
public class FeeDAOImpl extends BaseHibernate<Fee, Long> implements FeeDAO {

	public Fee getNextUnpaidFee(long planId) {
		Criteria criteria = createCriteria();
		criteria.createAlias("plan", "plan");
		criteria.add(Restrictions.eq("plan.id", planId));
		criteria.add(Restrictions.isNull("paymentDate"));
		criteria.addOrder(Order.asc("id"));
		criteria.setMaxResults(1);
		return (Fee) criteria.uniqueResult();
	}

}
