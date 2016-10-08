package ar.edu.unju.fi.soo.model;

import junit.framework.TestCase;

public class PlanTest extends TestCase {
	private String clientName = "nombre test";
	private Vehicle vehicle;
	private Client client;

	protected void setUp() {
		vehicle = new Vehicle(240000d);
		client = new Client(clientName, "");
	}

	/**
	 * Test Creación de plan de financiación Regular
	 */
	public void testPlanRegular() {
		int expentantFeeQuantity = 60;
		double expentantFeeAmount = vehicle.getValue() / expentantFeeQuantity;

		Plan plan = new PlanRegular(vehicle, client, expentantFeeQuantity);

		assertEquals(expentantFeeQuantity, plan.fees.size());
		assertEquals(expentantFeeAmount, plan.fees.get(0).getAmount());
	}

	/**
	 * Test Creación de plan de financiación 7030
	 */
	public void testPlan7030() {
		Plan plan = new Plan7030(vehicle, client, 80);

		int expectantFeeQuantity = 80;
		double expectantFeeAmount = 2100;

		assertEquals(expectantFeeAmount, plan.fees.get(0).getAmount());
		assertEquals(expectantFeeQuantity, plan.fees.size());
	}

	/**
	 * Test de Pago de una Cuota
	 */

	public void testPayNextFee() {
		Plan plan = new PlanRegular(vehicle, client, 80);

		plan.payNextFee();

		assertTrue(plan.fees.get(0).isPaid());

	}

	/**
	 * Test de listado de cuotas impagas
	 */
	public void testUnpaidFees() {
		Plan plan = new PlanRegular(vehicle, client, 80);
		plan.payNextFee();
		plan.payNextFee();

		int expected = 78;

		assertEquals(expected, plan.getUnpaidFees().size());
	}

	/**
	 * Test de pago de siguiente cuota.
	 */
	public void testPayFeeDate() {
		Plan plan = new Plan7030(vehicle, client, 80);

		Double expected = plan.calculateChargeToPay();

		plan.payNextFee();

		Double actual = plan.calculateChargeToPay();

		assertTrue(expected > actual);
	}

	/**
	 * Test de generacion de
	 */
	public void testDateDifferenceBetweenGeneratedFees() {
		Plan plan = new Plan7030(vehicle, client, 80);

		long expectantDiffDate = 30 * 24 * 60 * 60 * 1000l;

		assertEquals(expectantDiffDate, (plan.fees.get(2).getDueDate().getTime() - plan.fees.get(1).getDueDate().getTime()));
	}

}
