package ar.edu.unju.fi.soo;

import java.util.List;

import org.hibernate.Transaction;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;
import ar.edu.unju.fi.soo.model.dao.impl.ClientDAOImpl;
import ar.edu.unju.fi.soo.util.HibernateUtil;

public class AppHibernate {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Transaction transaction = HibernateUtil.getSession().beginTransaction();

		ClientDAO clientDAO = new ClientDAOImpl();

		clientDAO.save(new Client("Debi", "localhost"));
		clientDAO.save(new Client("Jorge", "localhost"));
		clientDAO.save(new Client("Ezequiel", "Jujuy"));

		List<Client> clients = clientDAO.list();

		for (Client client : clients) {
			System.out.println("Client: " + client.getId() + " - " + client.getName() + " - " + client.getAddress());
		}

		transaction.commit();
	}
}
