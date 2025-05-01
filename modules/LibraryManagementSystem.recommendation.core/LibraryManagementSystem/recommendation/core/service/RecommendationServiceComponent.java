package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RecommendationServiceComponent implements RecommendationService{
	protected RepositoryUtil<Recommendation> recommendationRepository;

    public RecommendationServiceComponent(){
        this.recommendationRepository = new RepositoryUtil<Recommendation>(LibraryManagementSystem.recommendation.core.RecommendationComponent.class);
    }	
    // public abstract HashMap<String, Object> getRecommendation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List);
}
