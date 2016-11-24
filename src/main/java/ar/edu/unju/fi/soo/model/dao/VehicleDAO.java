package ar.edu.unju.fi.soo.model.dao;

import ar.edu.unju.fi.soo.model.Vehicle;

public interface VehicleDAO extends BaseDAO<Vehicle, Long> {
	Vehicle findByCode(String string);
}
