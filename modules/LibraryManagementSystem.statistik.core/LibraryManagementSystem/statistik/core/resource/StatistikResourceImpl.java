package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.statistik.StatistikFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class StatistikResourceImpl extends StatistikResourceComponent{
	
	private StatistikServiceImpl statistikServiceImpl = new StatistikServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/statistik")
    public HashMap<String,Object> createstatistik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Statistik result = statistikServiceImpl.createStatistik(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/statistik/update")
    public HashMap<String, Object> updateStatistik(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return statistikServiceImpl.updateStatistik(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/statistik/detail")
    public HashMap<String, Object> getStatistik(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return statistikServiceImpl.getStatistik(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/statistik/list")
    public List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return statistikServiceImpl.getAllStatistik(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/statistik/delete")
    public List<HashMap<String,Object>> deleteStatistik(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return statistikServiceImpl.deleteStatistik(requestBody);
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
	}
}
