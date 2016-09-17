package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private Vehicle vehicle;
    private Client client;
    private List<Fee> fees = new ArrayList<Fee>();

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
