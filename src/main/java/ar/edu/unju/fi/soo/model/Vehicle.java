package ar.edu.unju.fi.soo.model;

public class Vehicle {
	private Double value;

	public Vehicle() {
		super();
	}

	public Vehicle(Double value) {
		super();
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vehicle [value=" + value + "]";
	}
}
