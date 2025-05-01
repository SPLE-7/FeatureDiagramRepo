package LibraryManagementSystem.recommendation.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.recommendation.RecommendationFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class RecommendationServiceImpl extends RecommendationServiceComponent{

    public List<HashMap<String,Object>> saveRecommendation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Recommendation recommendation = createRecommendation(vmjExchange);
		recommendationRepository.saveObject(recommendation);
		return getAllRecommendation(vmjExchange);
	}

    public Recommendation createRecommendation(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		Recommendation Recommendation = RecommendationFactory.createRecommendation(
			"LibraryManagementSystem.recommendation.core.RecommendationImpl",
		daftarbukuimpl
		, akunimpl
		);
		Repository.saveObject(recommendation);
		return recommendation;
	}

    public Recommendation createRecommendation(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		Recommendation recommendation = RecommendationFactory.createRecommendation("LibraryManagementSystem.recommendation.core.RecommendationImpl", daftarbukuimpl, akunimpl);
		return recommendation;
	}

    public HashMap<String, Object> updateRecommendation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Recommendation recommendation = Repository.getObject(id);
		
		
		Repository.updateObject(recommendation);
		
		//to do: fix association attributes
		
		return recommendation.toHashMap();
		
	}

    public HashMap<String, Object> getRecommendation(Map<String, Object> requestBody){
		List<HashMap<String, Object>> recommendationList = getAllRecommendation("recommendation_impl");
		for (HashMap<String, Object> recommendation : recommendationList){
			int record_id = ((Double) recommendation.get("record_id")).intValue();
			if (record_id == id){
				return recommendation;
			}
		}
		return null;
	}

	public HashMap<String, Object> getRecommendationById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		Recommendation recommendation = recommendationRepository.getObject(id);
		return recommendation.toHashMap();
	}

    public List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Recommendation> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteRecommendation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllRecommendation(requestBody);
	}

	public void getRecommendation() {
		// TODO: implement this method
	}
}
