package LibraryManagementSystem.statistik.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.statistik.StatistikFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class StatistikServiceImpl extends StatistikServiceComponent{

    public List<HashMap<String,Object>> saveStatistik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Statistik statistik = createStatistik(vmjExchange);
		statistikRepository.saveObject(statistik);
		return getAllStatistik(vmjExchange);
	}

    public Statistik createStatistik(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		Statistik Statistik = StatistikFactory.createStatistik(
			"LibraryManagementSystem.statistik.core.StatistikImpl",
		daftarbukuimpl
		);
		Repository.saveObject(statistik);
		return statistik;
	}

    public Statistik createStatistik(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		Statistik statistik = StatistikFactory.createStatistik("LibraryManagementSystem.statistik.core.StatistikImpl", daftarbukuimpl);
		return statistik;
	}

    public HashMap<String, Object> updateStatistik(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Statistik statistik = Repository.getObject(id);
		
		
		Repository.updateObject(statistik);
		
		//to do: fix association attributes
		
		return statistik.toHashMap();
		
	}

    public HashMap<String, Object> getStatistik(Map<String, Object> requestBody){
		List<HashMap<String, Object>> statistikList = getAllStatistik("statistik_impl");
		for (HashMap<String, Object> statistik : statistikList){
			int record_id = ((Double) statistik.get("record_id")).intValue();
			if (record_id == id){
				return statistik;
			}
		}
		return null;
	}

	public HashMap<String, Object> getStatistikById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		Statistik statistik = statistikRepository.getObject(id);
		return statistik.toHashMap();
	}

    public List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Statistik> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteStatistik(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllStatistik(requestBody);
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
	}
}
