package ar.edu.unju.fi.soo.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Plan {
    protected Vehicle vehicle;
    protected Client client;
    protected List<Fee> fees = new ArrayList<Fee>();
    
    public List<Fee> getUnpaidFees() {
        List<Fee> unpaidFees = new ArrayList<Fee>();

        for (Fee fee : fees) {
            if (!fee.isPaid()) {
                unpaidFees.add(fee);
            }
        }

        return unpaidFees;
    }
    
    public Date getNextDueDate(Date fecha){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(fecha); // Configuramos la fecha que se recibe
    	calendar.add(Calendar.DAY_OF_YEAR, 30);  // numero de días a añadir, o restar en caso de días<0
    	return (Date) calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    
    }
    public abstract void generateFees(int feesAmount);

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
