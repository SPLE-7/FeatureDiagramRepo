package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.recommendation.RecommendationFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class RecommendationResourceImpl extends RecommendationResourceComponent{
	
	private RecommendationServiceImpl recommendationServiceImpl = new RecommendationServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/recommendation")
    public HashMap<String,Object> createrecommendation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Recommendation result = recommendationServiceImpl.createRecommendation(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/recommendation/update")
    public HashMap<String, Object> updateRecommendation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return recommendationServiceImpl.updateRecommendation(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/recommendation/detail")
    public HashMap<String, Object> getRecommendation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return recommendationServiceImpl.getRecommendation(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/recommendation/list")
    public List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return recommendationServiceImpl.getAllRecommendation(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/recommendation/delete")
    public List<HashMap<String,Object>> deleteRecommendation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return recommendationServiceImpl.deleteRecommendation(requestBody);
	}

	public void getRecommendation() {
		// TODO: implement this method
	}
}
