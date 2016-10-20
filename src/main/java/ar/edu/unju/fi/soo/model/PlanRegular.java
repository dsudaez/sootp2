package ar.edu.unju.fi.soo.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("planRegular")
public class PlanRegular extends Plan {

	public PlanRegular() {
		super();
	}

	public PlanRegular(Vehicle vehicle, Client client, int feesAmount) {
		super(vehicle, client, feesAmount);
	}

	@Override
	public Double calculateChargeToPay() {
		List<Fee> unpaidFees = this.getUnpaidFees();
		double money = 0d;
		for (Fee fee : unpaidFees) {
			money += fee.getAmount();
		}
		return money;
	}

	public Double getAmountToFinance() {
		return getVehicle().getValue();
	}
}
