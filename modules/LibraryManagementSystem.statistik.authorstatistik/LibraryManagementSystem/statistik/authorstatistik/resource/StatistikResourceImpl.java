package LibraryManagementSystem.statistik.authorstatistik;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikResourceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.statistik.core.StatistikResourceComponent;

public class StatistikResourceImpl extends StatistikResourceDecorator {
    public StatistikResourceImpl (StatistikResourceComponent record) {
        super(record);
    }

	// TODO: BELOM SEMUA
    // @Restriced(permission = "")
    @Route(url="call/authorstatistik/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Statistik create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.authorstatistik.core.StatistikImpl", , );
			return deco;
	}

    public Statistik create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.authorstatistik.core.StatistikImpl", id, , );
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/authorstatistik/update")
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
    @Route(url="call/authorstatistik/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getStatistik(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/authorstatistik/list")
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
    @Route(url="call/authorstatistik/delete")
    public List<HashMap<String,Object>> deleteStatistik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
	}
}
