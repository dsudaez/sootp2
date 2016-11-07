package ar.edu.unju.fi.soo.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unju.fi.soo.model.dao.BaseDAO;

public class BaseHibernate<T, ID extends Serializable> implements BaseDAO<T, ID> {
	private Class<T> clazz;

	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public BaseHibernate() {
		super();

		ParameterizedType gen = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] typeArguments = gen.getActualTypeArguments();
		if (typeArguments.length == 0) {
			throw new IllegalArgumentException("Debe especificar el tipo/clase de dominio.");
		}
		clazz = (Class<T>) typeArguments[0];
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T object) {
		getSession().saveOrUpdate(object);
	}

	@Override
	public void delete(T object) {
		getSession().delete(object);
	}

	@Override
	public T get(ID id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return createCriteria().list();
	}

	public Criteria createCriteria() {
		return getSession().createCriteria(clazz);
	}
}
