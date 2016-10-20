package ar.edu.unju.fi.soo.model.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {

	void save(T object);

	void delete(T object);

	T get(ID id);

	List<T> list();

}
