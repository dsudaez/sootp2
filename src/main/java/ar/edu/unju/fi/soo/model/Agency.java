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
    
    public void createPlan7030 (){
    	
    }
    
    public void createPlanRegular (){
    	
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

}
