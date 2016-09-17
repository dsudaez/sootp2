package ar.edu.unju.fi.soo.model;

import java.util.Date;

public class Fee {
    private int number;
    private double amount;
    private Date dueDate;
    private Date paymentDate;

    public boolean isPaid() {
        return paymentDate != null;
    }

    public void pay() {
        paymentDate = new Date();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
}
