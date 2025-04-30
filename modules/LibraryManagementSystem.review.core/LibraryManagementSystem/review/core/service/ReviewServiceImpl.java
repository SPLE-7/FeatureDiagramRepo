package LibraryManagementSystem.review.core;
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
import LibraryManagementSystem.review.ReviewFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReviewServiceImpl extends ReviewServiceComponent{

    public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Review review = createReview(vmjExchange);
		reviewRepository.saveObject(review);
		return getAllReview(vmjExchange);
	}

    public Review createReview(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		Review Review = ReviewFactory.createReview(
			"LibraryManagementSystem.review.core.ReviewImpl",
		idReview
		, postedAt
		, daftarbukuimpl
		);
		Repository.saveObject(review);
		return review;
	}

    public Review createReview(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		Review review = ReviewFactory.createReview("LibraryManagementSystem.review.core.ReviewImpl", postedAt, daftarbukuimpl);
		return review;
	}

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idReview");
		int id = Integer.parseInt(idStr);
		Review review = Repository.getObject(id);
		
		
		Repository.updateObject(review);
		
		//to do: fix association attributes
		
		return review.toHashMap();
		
	}

    public HashMap<String, Object> getReview(Map<String, Object> requestBody){
		List<HashMap<String, Object>> reviewList = getAllReview("review_impl");
		for (HashMap<String, Object> review : reviewList){
			int record_id = ((Double) review.get("record_id")).intValue();
			if (record_id == id){
				return review;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReviewById(int id){
		String idStr = vmjExchange.getGETParam("idReview"); 
		int id = Integer.parseInt(idStr);
		Review review = reviewRepository.getObject(id);
		return review.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Review> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReview(requestBody);
	}

}
