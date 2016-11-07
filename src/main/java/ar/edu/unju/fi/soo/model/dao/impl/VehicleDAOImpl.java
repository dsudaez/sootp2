package ar.edu.unju.fi.soo.model.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.model.dao.VehicleDAO;

@Repository
public class VehicleDAOImpl extends BaseHibernate<Vehicle, Long> implements VehicleDAO {

}
