package ar.edu.unju.fi.soo.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.model.dao.VehicleDAO;

@Repository
public class VehicleDAOImpl extends BaseHibernate<Vehicle, Long> implements VehicleDAO {

	@Override
	public Vehicle findByCode(String code) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("code", code));
		@SuppressWarnings("unchecked")
		List<Vehicle> list = criteria.list();
		return list.isEmpty() ? null : list.get(0);
	}

	

}
