package ar.edu.unju.fi.soo.model;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class PlanTest extends TestCase{
	
	/**
	 * Test Creación de plan de financiación Regular 
	 */
	public void testPlanRegular(){
  	  String clientName = "nombre test";
  	  
  	  Client client = new Client(clientName,"");
  	  Plan plan = new PlanRegular(new Vehicle(240000d), client, 60);
  	  
  	  int expentantFeeQuantity = 60;
  	  double expentantFeeAmount =  4000;
  	  
  	  assertEquals(expentantFeeQuantity, plan.fees.size() );
  	  assertEquals(expentantFeeAmount, plan.fees.get(0).getAmount());
	}
	/**
	 * Test Creación de plan de financiación 7030 
	 */
    public void testPlan7030(){
  	  String clientName = "nombre test";
  	  
  	  Client client = new Client(clientName,"");
  	  Plan plan = new Plan7030(new Vehicle(240000d), client, 80);
  	  
  	  int expectantFeeQuantity = 80;
  	  double expectantFeeAmount = 2100;
  	  
  	  assertEquals(expectantFeeAmount, plan.fees.get(0).getAmount());
  	  assertEquals(expectantFeeQuantity, plan.fees.size());
    }
    
    /**
	 * Test de Pago de una Cuota
	 */
    
    public void testPayNextFee(){
   	 String clientName = "nombre test";
   	 
   	 Client client = new Client(clientName,"");
   	 Plan plan = new PlanRegular(new Vehicle(240000d), client, 80);

   	 plan.payNextFee();
   	 boolean expected = true;
     
   	 assertEquals(expected, plan.fees.get(0).isPaid());
     
    }
    
    /**
	 * Test de listado de cuotas impagas
	 */
    public void testUnpaidFees(){
  	  String clientName = "nombre test";
  	  
  	  Client client = new Client(clientName,"");
  	  Plan plan = new PlanRegular(new Vehicle(240000d), client, 80);
  	  plan.payNextFee();
  	  plan.payNextFee();
  	  
  	  int expected = 78;
  	  
  	  assertEquals(expected, plan.getUnpaidFees().size());
    }
    
    /**
	 * Test de pago de siguiente cuota.
	 */
    public void testPayFeeDate(){
  	  String clientName = "nombre test";
  	  
  	  Client client = new Client(clientName,"");
  	  Plan plan = new Plan7030(new Vehicle(240000d), client, 80);
  	  plan.payNextFee();
  	  
  	  Date date = new Date();
  	  Calendar expectantDate = Calendar.getInstance();
  	  expectantDate.setTime(date);
  	  
  	  assertEquals(expectantDate.getTime(), plan.fees.get(0).getPaymentDate());
    }
    
    /**
	 * Test de generacion de 
	 */
    public void testGenerateFees(){
  	  String clientName = "nombre test";
  	  
  	  Client client = new Client(clientName,"");
  	  Plan plan = new Plan7030(new Vehicle(240000d), client, 80);
  	  
  	  int expectantDiffDate = 30;
  	  
  	  assertEquals(expectantDiffDate, (plan.fees.get(2).getDueDate().getTime() - plan.fees.get(1).getDueDate().getTime()) / 86400000);
  	  
    }
	
}
