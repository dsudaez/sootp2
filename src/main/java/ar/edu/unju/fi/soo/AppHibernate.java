package ar.edu.unju.fi.soo;


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
		
		Client client = new Client("Jorge", "localhost");
		clientDAO.save(client);
		
		transaction.commit();
	}
}
