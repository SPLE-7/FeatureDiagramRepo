package LibraryManagementSystem.recommendation.recommendationbyauthor;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.recommendation.core.RecommendationResourceDecorator;
import LibraryManagementSystem.recommendation.core.RecommendationImpl;
import LibraryManagementSystem.recommendation.core.RecommendationResourceComponent;

public class RecommendationResourceImpl extends RecommendationResourceDecorator {
    private RecommendationServiceImpl recommendationServiceImpl;

	public RecommendationResourceImpl (RecommendationResourceComponent record, RecommendationServiceImpl recommendationServiceImpl) {
        super(record);
		this.recommendationServiceImpl = recommendationServiceImpl;
    }

	// @Restriced(permission = "")
    // @Route(url="call/recommendationbyauthor/detail")
    // public HashMap<String, Object> get(VMJExchange vmjExchange){
	// 	return record.getRecommendation(vmjExchange);
	// }

	// @Restriced(permission = "")
    @Route(url="call/recommendationbyauthor/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return recommendationServiceImpl.getAllRecommendation(vmjExchange.getPayload());
	}

	public List<Buku> generateRecommendationAuthor() {
		// TODO: implement this method
	}
}
