package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "plan")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "plan")
public abstract class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "VEHICLE_ID", nullable = false)
	protected Vehicle vehicle;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	protected Client client;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FEE_ID")
	protected List<Fee> fees = new ArrayList<Fee>();

	public Plan() {
	}

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
