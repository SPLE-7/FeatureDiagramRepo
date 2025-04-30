package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PeminjamanBukuResourceImpl extends PeminjamanBukuResourceComponent{
	
	private PeminjamanBukuServiceImpl peminjamanbukuServiceImpl = new PeminjamanBukuServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/peminjamanbuku")
    public HashMap<String,Object> createpeminjamanbuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PeminjamanBuku result = peminjamanbukuServiceImpl.createPeminjamanBuku(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/peminjamanbuku/update")
    public HashMap<String, Object> updatePeminjamanBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return peminjamanbukuServiceImpl.updatePeminjamanBuku(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/peminjamanbuku/detail")
    public HashMap<String, Object> getPeminjamanBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return peminjamanbukuServiceImpl.getPeminjamanBuku(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/peminjamanbuku/list")
    public List<HashMap<String,Object>> getAllPeminjamanBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return peminjamanbukuServiceImpl.getAllPeminjamanBuku(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/peminjamanbuku/delete")
    public List<HashMap<String,Object>> deletePeminjamanBuku(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return peminjamanbukuServiceImpl.deletePeminjamanBuku(requestBody);
	}

}
