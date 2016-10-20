package ar.edu.unju.fi.soo.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;

public class ClientDAOImpl extends BaseHibernate<Client, Long> implements ClientDAO {

	public Client findByName(String name) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("name", name));
		@SuppressWarnings("unchecked")
		List<Client> list = criteria.list();
		return list.isEmpty() ? null : list.get(0);
	}
}
