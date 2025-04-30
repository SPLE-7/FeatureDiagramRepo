package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RecommendationServiceComponent implements RecommendationService{
	protected RepositoryUtil<Recommendation> Repository;

    public RecommendationServiceComponent(){
        this.Repository = new RepositoryUtil<Recommendation>(LibraryManagementSystem.recommendation.core.RecommendationComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveRecommendation(VMJExchange vmjExchange);
    public abstract Recommendation createRecommendation(Map<String, Object> requestBodye);
	public abstract Recommendation createRecommendation(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateRecommendation(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getRecommendation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List);
    public abstract List<HashMap<String,Object>> deleteRecommendation(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getRecommendationById(int id);

	public abstract void getRecommendation();
}
