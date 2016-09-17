package ar.edu.unju.fi.soo.model;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private List<Plan> plans = new ArrayList<Plan>();

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

}
