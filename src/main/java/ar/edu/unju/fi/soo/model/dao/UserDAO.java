package ar.edu.unju.fi.soo.model.dao;

import ar.edu.unju.fi.soo.model.User;

public interface UserDAO extends BaseDAO<User, Long> {
	User login(String username, String password);
}
