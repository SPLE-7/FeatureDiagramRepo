package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.daftarbuku.DaftarBukuFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class DaftarBukuResourceImpl extends DaftarBukuResourceComponent{
	
	private DaftarBukuServiceImpl daftarbukuServiceImpl = new DaftarBukuServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/daftarbuku")
    public HashMap<String,Object> createdaftarbuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			DaftarBuku result = daftarbukuServiceImpl.createDaftarBuku(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/daftarbuku/update")
    public HashMap<String, Object> updateDaftarBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return daftarbukuServiceImpl.updateDaftarBuku(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/daftarbuku/detail")
    public HashMap<String, Object> getDaftarBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return daftarbukuServiceImpl.getDaftarBuku(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/daftarbuku/list")
    public List<HashMap<String,Object>> getAllDaftarBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return daftarbukuServiceImpl.getAllDaftarBuku(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/daftarbuku/delete")
    public List<HashMap<String,Object>> deleteDaftarBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return daftarbukuServiceImpl.deleteDaftarBuku(requestBody);
	}

}
