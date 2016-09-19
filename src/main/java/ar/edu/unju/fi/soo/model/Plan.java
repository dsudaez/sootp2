package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Plan {
	protected Vehicle vehicle;
	protected Client client;
	protected List<Fee> fees = new ArrayList<Fee>();

	public Plan() {
	}

	public Plan(Vehicle vehicle, Client client, int feesAmount) {
		this.vehicle = vehicle;
		this.client = client;
		generateFees(feesAmount);
	}

	public List<Fee> getUnpaidFees() {
		List<Fee> unpaidFees = new ArrayList<Fee>();

		for (Fee fee : fees) {
			if (!fee.isPaid()) {
				unpaidFees.add(fee);
			}
		}

		return unpaidFees;
	}

	public Date getNextDueDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		return (Date) calendar.getTime();
	}

	public void generateFees(int feesAmount) {
		if ((feesAmount >= 60) && (feesAmount <= 80)) {
			Double vehiclePrice = getAmountToFinance();
			Date feeDueDate = new Date();

			for (int i = 0; i < feesAmount; i++) {
				Fee feeToAdd = new Fee(i, vehiclePrice, feeDueDate);
				this.fees.add(feeToAdd);
				feeDueDate = getNextDueDate(feeDueDate);
			}
		}
	}

	public abstract Double getAmountToFinance();

	public abstract Double calculateChargeToPay();

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

}
