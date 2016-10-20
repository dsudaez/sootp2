package ar.edu.unju.fi.soo.dao.impl;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.impl.ClientDAOImpl;
import junit.framework.TestCase;

public class ClientDAOImplTestCase extends TestCase {
	private ClientDAOImpl clientDAOImpl;

	protected void setUp() {
		clientDAOImpl = new ClientDAOImpl();
	}

	public void testList() {
		clientDAOImpl.save(new Client("name", "address"));

		List<Client> clients = clientDAOImpl.list();

		assertNotNull(clients);
		assertTrue(clients.size() > 0);
	}

}
