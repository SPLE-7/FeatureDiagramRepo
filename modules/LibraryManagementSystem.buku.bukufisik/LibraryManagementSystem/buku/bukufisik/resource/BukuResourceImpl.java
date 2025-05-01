package LibraryManagementSystem.buku.bukufisik;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuResourceDecorator;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuResourceComponent;

public class BukuResourceImpl extends BukuResourceDecorator {
    public BukuResourceImpl (BukuResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/bukufisik/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Buku create(VMJExchange vmjExchange){
		String jumlahBukuStr = (String) vmjExchange.getRequestBodyForm("jumlahBuku");
		int jumlahBuku = Integer.parseInt(jumlahBukuStr);
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.bukufisik.core.BukuImpl", , jumlahBuku);
			return deco;
	}

    public Buku create(VMJExchange vmjExchange, int id){
		String jumlahBukuStr = (String) vmjExchange.getRequestBodyForm("jumlahBuku");
		int jumlahBuku = Integer.parseInt(jumlahBukuStr);
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.bukufisik.core.BukuImpl", id, , jumlahBuku);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/bukufisik/update")
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
    @Route(url="call/bukufisik/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBuku(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/bukufisik/list")
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
    @Route(url="call/bukufisik/delete")
    public List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
