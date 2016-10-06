package ar.edu.unju.fi.soo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Plan {
	@Id
	private Long id;
	protected Vehicle vehicle;
	protected Client client;
	protected List<Fee> fees = new ArrayList<Fee>();

	public Plan(Vehicle vehicle, Client client, int fees) {
		if (vehicle == null || client == null) {
			throw new IllegalArgumentException("Debe especificarse un vehiculo y un cliente.");
		}

		this.vehicle = vehicle;
		this.client = client;
		generateFees(fees);
	}

	@Transient
	public List<Fee> getUnpaidFees() {
		List<Fee> unpaidFees = new ArrayList<Fee>();
		for (Fee fee : fees) {
			if (!fee.isPaid()) {
				unpaidFees.add(fee);
			}
		}
		return unpaidFees;
	}

	public void payNextFee() {
		for (Fee fee : fees) {
			if (!fee.isPaid()) {
				fee.pay();
				return;
			}
		}
	}

	@Transient
	public Date getNextDueDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		return calendar.getTime();
	}

	public void generateFees(int feesQuantity) {
		if (feesQuantity != 60 && feesQuantity != 80) {
			throw new IllegalArgumentException("El numero de cuotas es invalido.");
		}

		Double vehiclePrice = getAmountToFinance();
		Double feeAmount = vehiclePrice / feesQuantity;
		Date feeDueDate = new Date();

		for (int i = 0; i < feesQuantity; i++) {
			feeDueDate = getNextDueDate(feeDueDate);
			Fee feeToAdd = new Fee(i, feeAmount, feeDueDate);
			this.fees.add(feeToAdd);
		}
	}

	public abstract Double getAmountToFinance();

	public abstract Double calculateChargeToPay();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Plan [vehicle=" + vehicle + ", client=" + client + ", fees=" + fees.size() + "]";
	}
}
