package ar.edu.unju.fi.soo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.soo.model.Agency;
import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Vehicle;

/**
 * Hello world!
 *
 */
public class App {
	private static NumberFormat numberFormat = DecimalFormat.getCurrencyInstance();
	
	Agency agency = new Agency();
	Vehicle chevroletCamaro = new Vehicle(1285000d);
	Vehicle fordMustang = new Vehicle(1250000d);
	Vehicle fordFocus = new Vehicle(425000d);

	public void addSamplePlanRegularWith60Fees() {
		Client client = new Client();
		client.setName("Jorge");
		int feesAmount = 60;

		agency.createPlanRegular(chevroletCamaro, client, feesAmount);
	}

	public void addSamplePlan7030With60Fees() {
		Client client = new Client();
		client.setName("Debi");
		int feesAmount = 80;

		agency.createPlan7030(fordMustang, client, feesAmount);
	}

	public void addSamplePlanRegularWith80Fees() {
		Client client = new Client("Ezequiel", "Jujuy");
		int feesAmount = 60;

		agency.createPlan7030(fordFocus, client, feesAmount);
	}

	public void addSamplePlan7030With80Fees() {
		Client client = new Client("Ezequiel", "Jujuy");
		int feesAmount = 80;

		agency.createPlan7030(fordFocus, client, feesAmount);
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		App app = new App();
		// Creamos planes en sus distintas variantes
		app.addSamplePlanRegularWith60Fees();
		app.addSamplePlan7030With60Fees();
		app.addSamplePlanRegularWith80Fees();
		app.addSamplePlan7030With80Fees();

		Agency agency = app.agency;

		// Mostramos los planes creados
		for (Plan plan : agency.getPlans()) {
			System.out.println(plan);
		}

		// Cantidad total que la agencia tiene por cobrar por todos los planes
		System.out.println("Por cobrar de todos los planes: " + numberFormat.format(agency.getMoneyReceivable()));
		System.out.println("Cliente que menos debe: " + agency.getLeastDebtor());

		//
		Plan plan = agency.findPlanByClientName("Jorge");

		if (plan != null) {
			List<Fee> unpaidFees = plan.getUnpaidFees();
			System.out.println("La cantidad de cuotas que faltan pagar son " + unpaidFees.size());
			
			//
			System.out.println("Pagamos una cuota.");
			plan.payNextFee();

			List<Fee> unpaidFeesAfterPay = plan.getUnpaidFees();
			System.out.println("La cantidad de cuotas que faltan pagar ahora son " + unpaidFeesAfterPay.size());

			// Cantidad total que la agencia tiene por cobrar por todos los planes
			System.out.println("Por cobrar de todos los planes: " + numberFormat.format(agency.getMoneyReceivable()));
			System.out.println("Cliente que menos debe: " + agency.getLeastDebtor());
		}
	}
}
