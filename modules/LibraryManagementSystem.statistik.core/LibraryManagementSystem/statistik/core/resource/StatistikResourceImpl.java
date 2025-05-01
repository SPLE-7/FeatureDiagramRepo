package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.statistik.StatistikFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class StatistikResourceImpl extends StatistikResourceComponent{
	
	private StatistikServiceImpl statistikServiceImpl = new StatistikServiceImpl();

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

	public int hitungTotalBuku() {
		// TODO: implement this method
	}
}
