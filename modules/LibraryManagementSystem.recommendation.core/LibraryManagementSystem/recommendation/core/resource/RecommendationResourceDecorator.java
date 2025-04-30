package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class RecommendationResourceDecorator extends RecommendationResourceComponent{
	protected RecommendationResourceComponent record;

    public RecommendationResourceDecorator(RecommendationResourceComponent record) {
        this.record = record;
    }

    public Recommendation createRecommendation(VMJExchange vmjExchange){
		return record.createRecommendation(vmjExchange);
	}

    public HashMap<String, Object> updateRecommendation(VMJExchange vmjExchange){
		return record.updateRecommendation(vmjExchange);
	}

    public HashMap<String, Object> getRecommendation(VMJExchange vmjExchange){
		return record.getRecommendation(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange){
		return record.getAllRecommendation(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteRecommendation(VMJExchange vmjExchange){
		return record.deleteRecommendation(vmjExchange);
	}

	public void getRecommendation() {
		return record.getRecommendation();
	}
}
