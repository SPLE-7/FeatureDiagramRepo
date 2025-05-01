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
import vmj.auth.annotations.Restricted;
//add other required packages

public class StatistikServiceImpl extends StatistikServiceComponent{


    // public HashMap<String, Object> getStatistik(Map<String, Object> requestBody){
	// 	List<HashMap<String, Object>> statistikList = getAllStatistik("statistik_impl");
	// 	for (HashMap<String, Object> statistik : statistikList){
	// 		// TODO
	// 		// int record_id = ((Double) statistik.get("record_id")).intValue();
	// 		// if (record_id == id){
	// 		// 	return statistik;
	// 		// }
	// 	}
	// 	return null;
	// }

    public List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Statistik> List = statistikRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
	}

	public List<Buku> getListObject() {
        return statistikRepository.getListObject("table_name", "amount", "10000");
    }
}
