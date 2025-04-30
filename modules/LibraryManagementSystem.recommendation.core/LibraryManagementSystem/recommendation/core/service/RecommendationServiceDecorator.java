package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class RecommendationServiceDecorator extends RecommendationServiceComponent{
	protected RecommendationServiceComponent record;

    public RecommendationServiceDecorator(RecommendationServiceComponent record) {
        this.record = record;
    }

	public RecommendationImpl createRecommendation(Map<String, Object> requestBody){
		return record.createRecommendation(requestBody);
	}

    public Recommendation createRecommendation(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createRecommendation(requestBody, response);
	}

	public HashMap<String, Object> getRecommendation(Map<String, Object> requestBody){
		return record.getRecommendation(requestBody);
	}

	public List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody){
		return record.getAllRecommendation(requestBody);
	}

    public List<HashMap<String,Object>> saveRecommendation(VMJExchange vmjExchange){
		return record.saveRecommendation(vmjExchange);
	}

    public HashMap<String, Object> updateRecommendation(Map<String, Object> requestBody){
		return record.updateRecommendation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteRecommendation(Map<String, Object> requestBody){
		return record.deleteRecommendation(requestBody);
	}

	public HashMap<String, Object> getRecommendationById(int id){
        return record.getRecommendationById(id);
    }

	public void getRecommendation() {
		return record.getRecommendation();
	}
}
