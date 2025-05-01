package LibraryManagementSystem.buku.bukufisik;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuResourceDecorator;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuResourceComponent;

public class BukuResourceImpl extends BukuResourceDecorator {
    private BukuServiceImpl bukuServiceImpl;
	
	public BukuResourceImpl (BukuResourceComponent record, BukuServiceComponent bukuServiceComponent) {
        super(record);
		this.bukuServiceImpl = new BukuServiceImpl(bukuServiceComponent);
    }

	// TODO:BELOM SEMUA

	@Route(url="call/bukufisik/create")
    public Buku create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return bukuServiceImpl.createBuku(vmjExchange.getPayload());
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
