package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RecommendationResource {
    HashMap<String, Object> getRecommendation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange);
}
