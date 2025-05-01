package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RecommendationService {
	// HashMap<String, Object> getRecommendation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Recommendation> List);
}
