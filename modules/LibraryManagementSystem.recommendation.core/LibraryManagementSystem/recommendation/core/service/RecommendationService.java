package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RecommendationService {
	Recommendation createRecommendation(Map<String, Object> requestBody);
	Recommendation createRecommendation(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getRecommendation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveRecommendation(Map<String, Object> requestBody);
    HashMap<String, Object> updateRecommendation(Map<String, Object> requestBody);
    HashMap<String, Object> getRecommendationById(int id);
    List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteRecommendation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
