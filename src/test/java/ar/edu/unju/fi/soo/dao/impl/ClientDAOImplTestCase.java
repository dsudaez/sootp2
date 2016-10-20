package ar.edu.unju.fi.soo.dao.impl;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;
import ar.edu.unju.fi.soo.model.dao.impl.ClientDAOImpl;
import junit.framework.TestCase;

public class ClientDAOImplTestCase extends TestCase {
	private ClientDAO clientDAO;

	protected void setUp() {
		clientDAO = new ClientDAOImpl();
	}

	public void testCrud() {
		String name = "Ezequiel";

		Client client = new Client(name, "address");

		// Save the client
		clientDAO.save(client);
		// ...and it have an ID now
		assertNotNull(client.getId());

		// Find the client by name
		Client clientFound = clientDAO.findByName(name);
		// ... and the client exists.
		assertNotNull(clientFound);

		// Delete the client found
		clientDAO.delete(clientFound);


		// Find the client by name again
		Client clientNotFound = clientDAO.findByName(name);
		// ... and the client doesn't exist.
		assertNull(clientNotFound);
	}

	public void testSaveAndList() {
		// List all the clients
		List<Client> clients = clientDAO.list();
		// and the returned list must be not null
		assertNotNull(clients);

		// Save a new client.
		clientDAO.save(new Client("Ezequiel", "address"));
		// and list all the clients again
		List<Client> clients2 = clientDAO.list();
		// and the returned list must be not null
		assertNotNull(clients2);
		// and the new list have an extra result.
		assertTrue(clients2.size() == clients.size() + 1);
	}

}
