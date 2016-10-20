package ar.edu.unju.fi.soo.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("plan7030")
public class Plan7030 extends Plan {
	private static final double _70_PERCENT = 0.70;
	private static final double _30_PERCENT = 0.30;

	public Plan7030() {
		super();
	}

	public Plan7030(Vehicle vehicle, Client client, int feesAmount) {
		super(vehicle, client, feesAmount);
	}

	@Override
	public Double calculateChargeToPay() {
		List<Fee> unpaidFees = this.getUnpaidFees();
		double money = this.getExtraordinaryFee();
		for (Fee fee : unpaidFees) {
			money = money + fee.getAmount();
		}
		return money;
	}

	public Double getExtraordinaryFee() {
		return getVehicle().getValue() * _30_PERCENT;
	}

	public Double getAmountToFinance() {
		return getVehicle().getValue() * _70_PERCENT;
	}
}
