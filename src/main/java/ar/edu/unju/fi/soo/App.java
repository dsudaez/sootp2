package ar.edu.unju.fi.soo;

import ar.edu.unju.fi.soo.model.Agency;
import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;

/**
 * Hello world!
 *
 */
public class App {
	Agency agency = new Agency();

	public void addSamplePlanRegular() {
		Vehicle chevroletCamaro = new Vehicle();
		chevroletCamaro.setValue(1285000.0);

		Client client = new Client();
		client.setName("Jorge");
		int feesAmount = 78;

		PlanRegular plan = agency.createPlanRegular(chevroletCamaro, client, feesAmount);
	}

	public void addSamplePlan7030() {
		Vehicle fordMustang = new Vehicle();
		fordMustang.setValue(1250000.0);

		Client client = new Client();
		client.setName("Debi");
		int feesAmount = 78;

		agency.createPlanRegular(fordMustang, client, feesAmount);
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
