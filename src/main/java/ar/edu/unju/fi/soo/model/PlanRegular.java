package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanRegular extends Plan {

	@Override
	public void generateFees(int feesAmount) {
		if ((feesAmount >= 60) && (feesAmount <= 80)) {
			Double precio = this.vehicle.getValue();
			Date hoy = new Date();
			Fee feetoadd1 = new Fee(0, precio, hoy);
			this.fees.add(feetoadd1);

			for (int i = 1; i < feesAmount; i++) {
				Date fecha = getNextDueDate(this.fees.get(i - 1).getDueDate());
				Fee feetoadd = new Fee(i, precio, fecha);
				this.fees.add(feetoadd);
			}
		}
	}

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

}
