package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public class Agency {
	private List<Plan> plans = new ArrayList<Plan>();

	public Plan findPlanByClientName(String clientName) {
		for(Plan plan : plans) {
			if (clientName.equalsIgnoreCase(plan.client.getName())) {
				return plan;
			}
		}
		return null;
	}

	public Double getMoneyReceivable() {
		double moneyReceivable = 0d;
		for (Plan plan : plans) {
			moneyReceivable = moneyReceivable + plan.calculateChargeToPay();
		}
		return moneyReceivable;
	}

	public Client getLeastDebtor() {
		Plan selectedPlan = plans.get(0);
		for (Plan plan : plans) {
			if (plan.calculateChargeToPay() < selectedPlan.calculateChargeToPay()) {
				selectedPlan = plan;
			}
		}
		return selectedPlan.getClient();
	}

	public Plan7030 createPlan7030(Vehicle vehicle, Client client, int feesAmount) {
		Plan7030 plan = new Plan7030(vehicle, client, feesAmount);
		plans.add(plan);
		return plan;
	}

	public PlanRegular createPlanRegular(Vehicle vehicle, Client client, int feesAmount) {
		PlanRegular plan = new PlanRegular(vehicle, client, feesAmount);
		plans.add(plan);
		return plan;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

}
