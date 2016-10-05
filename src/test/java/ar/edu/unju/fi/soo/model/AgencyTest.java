package ar.edu.unju.fi.soo.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class AgencyTest extends TestCase {

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
    
     public void testPayNextFee(){
    	 String clientName = "nombre test";
    	 
    	 Client client = new Client(clientName,"");
    	 Plan plan = new PlanRegular(new Vehicle(240000d), client, 80);

    	 plan.payNextFee();
    	 boolean expected = true;
         
         assertEquals(expected, plan.fees.get(0).isPaid());
             	
     }
      public void testUnpaidFees(){
    	  String clientName = "nombre test";
    	  
    	  Client client = new Client(clientName,"");
    	  Plan plan = new PlanRegular(new Vehicle(240000d), client, 80);
    	  plan.payNextFee();
    	  plan.payNextFee();
    	  
    	  int expected = 78;
    	  
    	  assertEquals(expected, plan.getUnpaidFees().size());
      }
      
      public void testPlanRegular(){
    	  String clientName = "nombre test";
    	  
    	  Client client = new Client(clientName,"");
    	  Plan plan = new PlanRegular(new Vehicle(240000d), client, 60);
    	  
    	  int expentantFeeQuantity = 60;
    	  double expentantFeeAmount =  4000;
    	  
    	  assertEquals(expentantFeeQuantity, plan.fees.size() );
    	  assertEquals(expentantFeeAmount, plan.fees.get(0).getAmount());
    	    	  
      }
      
      public void testPlan7030(){
    	  String clientName = "nombre test";
    	  
    	  Client client = new Client(clientName,"");
    	  Plan plan = new Plan7030(new Vehicle(240000d), client, 80);
    	  
    	  int expectantFeeQuantity = 80;
    	  double expectantFeeAmount = 2100;
    	  
    	  assertEquals(expectantFeeAmount, plan.fees.get(0).getAmount());
    	  assertEquals(expectantFeeQuantity, plan.fees.size());
    	      	  
      }
      
     
     
}
