package ar.edu.unju.fi.soo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Fee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number", nullable = false)
	private Integer number;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date", nullable = false)
	private Date dueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date", nullable = true)
	private Date paymentDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PLAN_ID", nullable = false)
	private Plan plan;

	@Transient
	public boolean isPaid() {
		return paymentDate != null;
	}

	public Fee() {
	}

	public Fee(Integer number, Double amount, Date dueDate) {
		super();
		this.number = number;
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public void pay() {
		paymentDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Fee [number=" + number + ", amount=" + amount + ", dueDate=" + dueDate + ", paymentDate=" + paymentDate
				+ "]";
	}
}
