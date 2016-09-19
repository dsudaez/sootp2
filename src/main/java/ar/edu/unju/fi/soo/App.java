package ar.edu.unju.fi.soo;

import java.util.ArrayList;

import ar.edu.unju.fi.soo.model.Agency;
import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Plan7030;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;

/**
 * Hello world!
 *
 */
public class App {
	Agency agency = new Agency();
	Vehicle chevroletCamaro = new Vehicle(1285000d);
	Vehicle fordMustang = new Vehicle(1250000d);
	Vehicle fordFocus = new Vehicle(425000d);

	public void addSamplePlanRegular() {
		Client client = new Client();
		client.setName("Jorge");
		int feesAmount = 78;

		PlanRegular plan = agency.createPlanRegular(chevroletCamaro, client, feesAmount);
		//11 cuotas pagadas
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		plan.payNextFee();
		
		ArrayList<Fee> unpaidFees=  (ArrayList<Fee>) plan.getUnpaidFees();
		System.out.println("la cantidad de cuotas que faltan pagar son " + unpaidFees.size());			
	}

	public void addSamplePlan7030() {
		Client client = new Client();
		client.setName("Debi");
		int feesAmount = 80;

		Plan7030 plan = agency.createPlan7030(fordMustang, client, feesAmount);
		plan.payNextFee();
	}

	public void addSamplePlan60() {
		Client client = new Client("Ezequiel", "Jujuy");
		int feesAmount = 60;

		Plan7030 plan = agency.createPlan7030(fordFocus, client, feesAmount);
		plan.payNextFee();
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Agency agency = new Agency();
		Vehicle vehicle = new Vehicle();
		vehicle.setValue(250000.0);
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setValue(285000.0);

		Client client = new Client();
		client.setName("Cliente 1");
		int feesAmount = 60;

		agency.createPlan7030(vehicle2, client, feesAmount);
		agency.createPlanRegular(vehicle, client, feesAmount);

		Client client2 = new Client();
		client2.setName("Cliente 2");
		feesAmount = 80;
		agency.createPlan7030(vehicle2, client2, feesAmount);
		agency.createPlanRegular(vehicle, client2, feesAmount);

		for (Plan plan : agency.getPlans()) {
			System.out.println(plan);
		}

		System.out.println("MoneyReceivable: " + agency.getMoneyReceivable());
		System.out.println("Cliente que menos debe: " + agency.getLeastDebtor());
	}
}
