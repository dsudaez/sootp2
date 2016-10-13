package ar.edu.unju.fi.soo.model.dao.impl;

import org.hibernate.Session;

import ar.edu.unju.fi.soo.util.HibernateUtil;

public class BaseHibernate {
	private Session session;

	public BaseHibernate() {
		super();
		session = HibernateUtil.getSession();
	}

	public Session getSession() {
		return session;
	}

}
