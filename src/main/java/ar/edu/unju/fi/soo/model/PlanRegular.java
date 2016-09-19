package ar.edu.unju.fi.soo.model;

import java.util.List;

public class PlanRegular extends Plan {

	public PlanRegular(Vehicle vehicle, Client client, int feesAmount) {
		super(vehicle, client, feesAmount);
	}

	@Override
	public Double calculateChargeToPay() {
		List<Fee> unpaidFees = this.getUnpaidFees();
		Double money = 0d;
		for (Fee fee : unpaidFees) {
			money = money + fee.getAmount();
		}
		return money;
	}

	public Double getAmountToFinance() {
		return getVehicle().getValue();
	}
}
