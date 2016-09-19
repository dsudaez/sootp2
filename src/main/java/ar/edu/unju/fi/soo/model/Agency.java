package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private List<Plan> plans = new ArrayList<Plan>();
    
    public Double getMoneyReceivable (){
        Double moneyReceivable = 0.0;
        for (Plan plan : plans){
         moneyReceivable += plan.calculateChargeToPay();
        }
        return moneyReceivable;
    }
       
    public Client getLeastDebtor(){
        Plan selectedPlan = plans.get(0);
        for (Plan plan : plans){
         if (plan.calculateChargeToPay() < selectedPlan.calculateChargeToPay()){
          selectedPlan = plan;
         }
        }
        return selectedPlan.getClient();
    }
    
    public void createPlan7030 (Vehicle vehicle, Client client, int feesAmount){
    	Plan7030 plan = new Plan7030();
    	plan.setClient(client);
    	plan.setVehicle(vehicle);
    	plan.generateFees();
    	plans.add(plan);
    }
    
    public void createPlanRegular (Vehicle vehicle, Client client, int feesAmount){
    	PlanRegular plan = new PlanRegular();
    	plan.setClient(client);
    	plan.setVehicle(vehicle);
    	plan.generateFees();
    	plans.add(plan);
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

}
