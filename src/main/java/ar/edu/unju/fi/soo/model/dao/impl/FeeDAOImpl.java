package ar.edu.unju.fi.soo.model.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.dao.BaseDAO;

@Repository
public class FeeDAOImpl extends BaseHibernate<Fee, Long> implements BaseDAO<Fee, Long> {

}
