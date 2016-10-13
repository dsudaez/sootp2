package ar.edu.unju.fi.soo.model.dao;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;

public interface ClientDAO {
	void save(Client client);
	Client get(Long id);
	List<Client> list();
	
}
