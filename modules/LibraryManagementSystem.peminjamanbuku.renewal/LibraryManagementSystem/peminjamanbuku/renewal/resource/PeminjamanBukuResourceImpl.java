package LibraryManagementSystem.peminjamanbuku.renewal;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceComponent;

public class PeminjamanBukuResourceImpl extends PeminjamanBukuResourceDecorator {
    public PeminjamanBukuResourceImpl (PeminjamanBukuResourceComponent record) {
        super(record);
    }

	// TODO: BELOM SEMUA
    // @Restriced(permission = "")
    @Route(url="call/renewal/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public PeminjamanBuku create(VMJExchange vmjExchange){
		String renewalCountStr = (String) vmjExchange.getRequestBodyForm("renewalCount");
		int renewalCount = Integer.parseInt(renewalCountStr);
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.renewal.core.PeminjamanBukuImpl", , renewalCount);
			return deco;
	}

    public PeminjamanBuku create(VMJExchange vmjExchange, int id){
		String renewalCountStr = (String) vmjExchange.getRequestBodyForm("renewalCount");
		int renewalCount = Integer.parseInt(renewalCountStr);
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.renewal.core.PeminjamanBukuImpl", id, , renewalCount);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/renewal/update")
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
    @Route(url="call/renewal/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPeminjamanBuku(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/renewal/list")
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
    @Route(url="call/renewal/delete")
    public List<HashMap<String,Object>> deletePeminjamanBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public boolean RequestRenewal() {
		// TODO: implement this method
	}
}
