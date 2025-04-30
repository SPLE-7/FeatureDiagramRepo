package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RecommendationResourceComponent implements RecommendationResource{
	
	public RecommendationResourceComponent() { }
 
    public abstract Recommendation createRecommendation(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateRecommendation(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getRecommendation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteRecommendation(VMJExchange vmjExchange);

	public abstract void getRecommendation();
}
