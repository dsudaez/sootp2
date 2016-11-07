package ar.edu.unju.fi.soo.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.User;
import ar.edu.unju.fi.soo.model.dao.UserDAO;

@Repository
public class UserDAOImpl extends BaseHibernate<User, Long> implements UserDAO {

	@Override
	public User login(String username, String password) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<User> list = criteria.list();
		return list.isEmpty() ? null : list.get(0);
	}
}
