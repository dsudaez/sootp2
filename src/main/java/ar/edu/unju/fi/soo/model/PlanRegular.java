package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public class PlanRegular extends Plan {

	@Override
	public Double calculateChargeToPay() {
		List<Fee> unpaidFees = new ArrayList<Fee>();
		unpaidFees = this.getUnpaidFees();
		Double money = 0.;
		for (Fee fee : unpaidFees) {
			money = money + fee.getAmount();
		}
		return money;
	}

	public Double getAmountToFinance() {
		return getVehicle().getValue();
	}
}
