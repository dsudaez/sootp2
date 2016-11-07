package ar.edu.unju.fi.soo.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
public class ClientDAOImplTestCase {
	@Inject
	private ClientDAO clientDAO;

	@Test
	public void testCrud() {
		String name = "Ezequiel " + Math.random();

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

	@Test
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
