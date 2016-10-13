package ar.edu.unju.fi.soo.model.dao.impl;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;

public class ClientDAOImpl extends BaseHibernate implements ClientDAO {

	@Override
	public void save(Client client) {
		getSession().save(client);		
	}

	@Override
	public Client get(Long id) {
		return getSession().get(Client.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> list() {
		return (List<Client>) getSession().createCriteria(Client.class).list();
	}

}
