package LibraryManagementSystem.review.reviewkomentar;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.review.core.ReviewResourceDecorator;
import LibraryManagementSystem.review.core.ReviewImpl;
import LibraryManagementSystem.review.core.ReviewResourceComponent;

public class ReviewResourceImpl extends ReviewResourceDecorator {
    public ReviewResourceImpl (ReviewResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/reviewkomentar/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Review create(VMJExchange vmjExchange){
		String commentValue = (String) vmjExchange.getRequestBodyForm("commentValue");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.reviewkomentar.core.ReviewImpl", , commentValue);
			return deco;
	}

    public Review create(VMJExchange vmjExchange, int id){
		String commentValue = (String) vmjExchange.getRequestBodyForm("commentValue");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.reviewkomentar.core.ReviewImpl", id, , commentValue);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/reviewkomentar/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewkomentar/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getReview(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewkomentar/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewkomentar/delete")
    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
