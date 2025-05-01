package LibraryManagementSystem.recommendation.recommendationbygenre;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.recommendation.core.RecommendationServiceDecorator;
import LibraryManagementSystem.recommendation.core.RecommendationImpl;
import LibraryManagementSystem.recommendation.core.RecommendationServiceComponent;

public class RecommendationServiceImpl extends RecommendationServiceDecorator {
    public RecommendationServiceImpl (RecommendationServiceComponent record) {
        super(record);
    }

    
	public List<Buku> generateRecommendationGenre() {
		// TODO: implement this method
	}
}
