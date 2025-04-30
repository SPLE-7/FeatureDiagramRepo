package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RecommendationResource {
    List<HashMap<String,Object>> saveRecommendation(VMJExchange vmjExchange);
    HashMap<String, Object> updateRecommendation(VMJExchange vmjExchange);
    HashMap<String, Object> getRecommendation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteRecommendation(VMJExchange vmjExchange);
	HashMap<String, Object> createRecommendation(VMJExchange vmjExhange);
}
