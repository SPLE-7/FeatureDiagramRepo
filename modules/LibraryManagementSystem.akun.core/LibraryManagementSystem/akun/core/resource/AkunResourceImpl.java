package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.akun.AkunFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AkunResourceImpl extends AkunResourceComponent{
	
	private AkunServiceImpl akunServiceImpl = new AkunServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/akun")
    public HashMap<String,Object> createakun(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Akun result = akunServiceImpl.createAkun(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/akun/update")
    public HashMap<String, Object> updateAkun(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return akunServiceImpl.updateAkun(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/akun/detail")
    public HashMap<String, Object> getAkun(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return akunServiceImpl.getAkun(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/akun/list")
    public List<HashMap<String,Object>> getAllAkun(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return akunServiceImpl.getAllAkun(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/akun/delete")
    public List<HashMap<String,Object>> deleteAkun(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return akunServiceImpl.deleteAkun(requestBody);
	}

}
