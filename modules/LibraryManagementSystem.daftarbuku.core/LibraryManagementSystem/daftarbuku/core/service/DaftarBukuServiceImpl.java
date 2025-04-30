package LibraryManagementSystem.daftarbuku.core;
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
import LibraryManagementSystem.daftarbuku.DaftarBukuFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class DaftarBukuServiceImpl extends DaftarBukuServiceComponent{

    public List<HashMap<String,Object>> saveDaftarBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		DaftarBuku daftarbuku = createDaftarBuku(vmjExchange);
		daftarbukuRepository.saveObject(daftarbuku);
		return getAllDaftarBuku(vmjExchange);
	}

    public DaftarBuku createDaftarBuku(Map<String, Object> requestBody){
		String judulBuku = (String) requestBody.get("judulBuku");
		String penulis = (String) requestBody.get("penulis");
		String penerbit = (String) requestBody.get("penerbit");
		String jumlahHalamanStr = (String) requestBody.get("jumlahHalaman");
		int jumlahHalaman = Integer.parseInt(jumlahHalamanStr);
		String deskripsiBuku = (String) requestBody.get("deskripsiBuku");
		String genre = (String) requestBody.get("genre");
		
		//to do: fix association attributes
		DaftarBuku DaftarBuku = DaftarBukuFactory.createDaftarBuku(
			"LibraryManagementSystem.daftarbuku.core.DaftarBukuImpl",
		idBuku
		, judulBuku
		, penulis
		, penerbit
		, jumlahHalaman
		, deskripsiBuku
		, genre
		);
		Repository.saveObject(daftarbuku);
		return daftarbuku;
	}

    public DaftarBuku createDaftarBuku(Map<String, Object> requestBody, int id){
		String judulBuku = (String) vmjExchange.getRequestBodyForm("judulBuku");
		String penulis = (String) vmjExchange.getRequestBodyForm("penulis");
		String penerbit = (String) vmjExchange.getRequestBodyForm("penerbit");
		String jumlahHalamanStr = (String) vmjExchange.getRequestBodyForm("jumlahHalaman");
		int jumlahHalaman = Integer.parseInt(jumlahHalamanStr);
		String deskripsiBuku = (String) vmjExchange.getRequestBodyForm("deskripsiBuku");
		String genre = (String) vmjExchange.getRequestBodyForm("genre");
		
		//to do: fix association attributes
		
		DaftarBuku daftarbuku = DaftarBukuFactory.createDaftarBuku("LibraryManagementSystem.daftarbuku.core.DaftarBukuImpl", judulBuku, penulis, penerbit, jumlahHalaman, deskripsiBuku, genre);
		return daftarbuku;
	}

    public HashMap<String, Object> updateDaftarBuku(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBuku");
		int id = Integer.parseInt(idStr);
		DaftarBuku daftarbuku = Repository.getObject(id);
		
		daftarbuku.setJudulBuku((String) requestBody.get("judulBuku"));
		daftarbuku.setPenulis((String) requestBody.get("penulis"));
		daftarbuku.setPenerbit((String) requestBody.get("penerbit"));
		String jumlahHalamanStr = (String) requestBody.get("jumlahHalaman");
		daftarbuku.setJumlahHalaman(Integer.parseInt(jumlahHalamanStr));
		daftarbuku.setDeskripsiBuku((String) requestBody.get("deskripsiBuku"));
		daftarbuku.setGenre((String) requestBody.get("genre"));
		
		Repository.updateObject(daftarbuku);
		
		//to do: fix association attributes
		
		return daftarbuku.toHashMap();
		
	}

    public HashMap<String, Object> getDaftarBuku(Map<String, Object> requestBody){
		List<HashMap<String, Object>> daftarbukuList = getAllDaftarBuku("daftarbuku_impl");
		for (HashMap<String, Object> daftarbuku : daftarbukuList){
			int record_id = ((Double) daftarbuku.get("record_id")).intValue();
			if (record_id == id){
				return daftarbuku;
			}
		}
		return null;
	}

	public HashMap<String, Object> getDaftarBukuById(int id){
		String idStr = vmjExchange.getGETParam("idBuku"); 
		int id = Integer.parseInt(idStr);
		DaftarBuku daftarbuku = daftarbukuRepository.getObject(id);
		return daftarbuku.toHashMap();
	}

    public List<HashMap<String,Object>> getAllDaftarBuku(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<DaftarBuku> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<DaftarBuku> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteDaftarBuku(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllDaftarBuku(requestBody);
	}

}
