package ar.edu.unju.fi.soo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	private Long id;
	private String name;
	private String address;

	public Client() {
		super();
	}

	public Client(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + "]";
	}

}
