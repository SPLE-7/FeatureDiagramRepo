package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class RecommendationServiceDecorator extends RecommendationServiceComponent{
	protected RecommendationServiceComponent record;

    public RecommendationServiceDecorator(RecommendationServiceComponent record) {
        this.record = record;
    }

	// public HashMap<String, Object> getRecommendation(Map<String, Object> requestBody){
	// 	return record.getRecommendation(requestBody);
	// }

	public List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody){
		return record.getAllRecommendation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List){
		return record.transformListToHashMap(List);
	}

}
