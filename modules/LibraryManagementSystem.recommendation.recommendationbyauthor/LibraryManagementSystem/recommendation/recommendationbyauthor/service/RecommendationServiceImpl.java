package LibraryManagementSystem.recommendation.recommendationbyauthor;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.recommendation.core.RecommendationServiceDecorator;
import LibraryManagementSystem.recommendation.core.RecommendationImpl;
import LibraryManagementSystem.recommendation.core.RecommendationServiceComponent;

public class RecommendationServiceImpl extends RecommendationServiceDecorator {
    public RecommendationServiceImpl (RecommendationServiceComponent record) {
        super(record);
    }

    
	public List<Buku> generateRecommendationAuthor() {
		// TODO: implement this method
	}
}
