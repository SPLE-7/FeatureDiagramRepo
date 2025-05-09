package LibraryManagementSystem.review.reviewkomentar;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.review.core.ReviewResourceDecorator;
import LibraryManagementSystem.review.core.ReviewImpl;
import LibraryManagementSystem.review.core.ReviewResourceComponent;

public class ReviewResourceImpl extends ReviewResourceDecorator {
    private ReviewServiceImpl reviewServiceImpl;
	
	public ReviewResourceImpl (ReviewResourceComponent record, ReviewServiceImpl reviewServiceImpl) {
        super(record);
		this.reviewServiceImpl = reviewServiceImpl;
    }

	@Route(url="call/reviewkomentar/create")
    public HashMap<String, Object> create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return reviewServiceImpl.createReview(vmjExchange.getPayload()).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewkomentar/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return reviewServiceImpl.getReview(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewkomentar/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return reviewServiceImpl.getAllReview(vmjExchange.getPayload());
	}

}
