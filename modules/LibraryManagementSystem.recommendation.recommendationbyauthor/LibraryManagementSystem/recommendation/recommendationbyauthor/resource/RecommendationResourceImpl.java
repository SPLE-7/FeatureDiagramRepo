package LibraryManagementSystem.recommendation.recommendationbyauthor;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.recommendation.core.RecommendationResourceDecorator;
import LibraryManagementSystem.recommendation.core.RecommendationImpl;
import LibraryManagementSystem.recommendation.core.RecommendationResourceComponent;

public class RecommendationResourceImpl extends RecommendationResourceDecorator {
    public RecommendationResourceImpl (RecommendationResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/recommendationbyauthor/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Recommendation create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.recommendationbyauthor.core.RecommendationImpl", , );
			return deco;
	}

    public Recommendation create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.recommendationbyauthor.core.RecommendationImpl", id, , );
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/recommendationbyauthor/update")
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
    @Route(url="call/recommendationbyauthor/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getRecommendation(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/recommendationbyauthor/list")
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
    @Route(url="call/recommendationbyauthor/delete")
    public List<HashMap<String,Object>> deleteRecommendation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public List<Buku> generateRecommendationAuthor() {
		// TODO: implement this method
	}
}
