package ar.edu.unju.fi.soo.model;

import java.util.List;

public class Plan7030 extends Plan {

	@Override
	public Double calculateChargeToPay() {
		List<Fee> unpaidFees = this.getUnpaidFees();
		Double money = this.getExtraordinaryFee();
		for (Fee fee : unpaidFees) {
			money = money + fee.getAmount();
		}
		return money;
	}

	public Double getExtraordinaryFee() {
		return getVehicle().getValue() * 0.3;
	}

	public Double getAmountToFinance() {
		return getVehicle().getValue() * 0.7;
	}
}
