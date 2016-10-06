package ar.edu.unju.fi.soo.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class AgencyTest extends TestCase {

	/**
	 * Test de buscar un plan por cliente
	 */
	public void testFindPlanByClient() {
        String expectedClientName = "nombre test";

        Agency agency = new Agency();
        Client client = new Client(expectedClientName, "");
        Plan plan = new PlanRegular(new Vehicle(240000d), client, 80);

        List<Plan> plans = new ArrayList<Plan>();
        plans.add(plan);
        agency.setPlans(plans);

        Plan planFound = agency.findPlanByClientName(expectedClientName);

        assertEquals(planFound.client.getName(), expectedClientName);
        assertEquals(planFound, plan);
    }
    
    /**
	 * Test de dinero por cobrar
	 */
    public void testMoneyReceivableCalculation() {
        String clientName = "nombre test";

        Agency agency = new Agency();
        Client client1 = new Client(clientName + "1", "");
        Client client2 = new Client(clientName + "2", "");

        agency.createPlan7030(new Vehicle(240000d), client1, 80);
        agency.createPlan7030(new Vehicle(240000d), client2, 60);

        double expected = 480000d;

        assertEquals(expected, agency.getMoneyReceivable());
    }

    /**
	 * Test de Cliente que menos debe
	 */
    public void testLeastDebtorClient() {
        String clientName = "nombre test";

        Agency agency = new Agency();
        Client expectedLeastDebtorClient = new Client(clientName + "1", "");
        Client anotherClient = new Client(clientName + "2", "");

        agency.createPlan7030(new Vehicle(240000d), expectedLeastDebtorClient, 80);
        agency.createPlan7030(new Vehicle(249999d), anotherClient, 60);

        Client clientFound = agency.getLeastDebtor();

        assertEquals(expectedLeastDebtorClient.getName(), clientFound.getName());
        assertEquals(expectedLeastDebtorClient, clientFound);
    }

}
