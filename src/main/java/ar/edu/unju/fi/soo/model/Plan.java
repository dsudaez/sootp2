package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Plan {
    private Vehicle vehicle;
    private Client client;
    private List<Fee> fees = new ArrayList<Fee>();
    
    public List<Fee> getUnpaidFees() {
        List<Fee> unpaidFees = new ArrayList<Fee>();

        for (Fee fee : fees) {
            if (!fee.isPaid()) {
                unpaidFees.add(fee);
            }
        }

        return unpaidFees;
    }
    public void payNextFee(){
    	for (Fee fee: fees){
    		if (!fee.isPaid()){
    			fee.pay();
    			return;
    		}
    	}
    }
    public abstract void generateFees();

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
