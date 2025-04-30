package LibraryManagementSystem.akun.core;
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
import LibraryManagementSystem.akun.AkunFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AkunServiceImpl extends AkunServiceComponent{

    public List<HashMap<String,Object>> saveAkun(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Akun akun = createAkun(vmjExchange);
		akunRepository.saveObject(akun);
		return getAllAkun(vmjExchange);
	}

    public Akun createAkun(Map<String, Object> requestBody){
		String nama = (String) requestBody.get("nama");
		
		//to do: fix association attributes
		Akun Akun = AkunFactory.createAkun(
			"LibraryManagementSystem.akun.core.AkunImpl",
		idAkun
		, nama
		);
		Repository.saveObject(akun);
		return akun;
	}

    public Akun createAkun(Map<String, Object> requestBody, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		
		//to do: fix association attributes
		
		Akun akun = AkunFactory.createAkun("LibraryManagementSystem.akun.core.AkunImpl", nama);
		return akun;
	}

    public HashMap<String, Object> updateAkun(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idAkun");
		int id = Integer.parseInt(idStr);
		Akun akun = Repository.getObject(id);
		
		akun.setNama((String) requestBody.get("nama"));
		
		Repository.updateObject(akun);
		
		//to do: fix association attributes
		
		return akun.toHashMap();
		
	}

    public HashMap<String, Object> getAkun(Map<String, Object> requestBody){
		List<HashMap<String, Object>> akunList = getAllAkun("akun_impl");
		for (HashMap<String, Object> akun : akunList){
			int record_id = ((Double) akun.get("record_id")).intValue();
			if (record_id == id){
				return akun;
			}
		}
		return null;
	}

	public HashMap<String, Object> getAkunById(int id){
		String idStr = vmjExchange.getGETParam("idAkun"); 
		int id = Integer.parseInt(idStr);
		Akun akun = akunRepository.getObject(id);
		return akun.toHashMap();
	}

    public List<HashMap<String,Object>> getAllAkun(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Akun> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Akun> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAkun(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllAkun(requestBody);
	}

}
