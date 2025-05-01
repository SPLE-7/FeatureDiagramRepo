package LibraryManagementSystem.buku.core;
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
import LibraryManagementSystem.buku.BukuFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BukuServiceImpl extends BukuServiceComponent{

    public List<HashMap<String,Object>> saveBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Buku buku = createBuku(vmjExchange);
		bukuRepository.saveObject(buku);
		return getAllBuku(vmjExchange);
	}

    public Buku createBuku(Map<String, Object> requestBody){
		String judulBuku = (String) requestBody.get("judulBuku");
		String penulis = (String) requestBody.get("penulis");
		String penerbit = (String) requestBody.get("penerbit");
		String jumlahHalamanStr = (String) requestBody.get("jumlahHalaman");
		int jumlahHalaman = Integer.parseInt(jumlahHalamanStr);
		String deskripsiBuku = (String) requestBody.get("deskripsiBuku");
		String genre = (String) requestBody.get("genre");
		
		//to do: fix association attributes
		Buku Buku = BukuFactory.createBuku(
			"LibraryManagementSystem.buku.core.BukuImpl",
		idBuku
		, judulBuku
		, penulis
		, penerbit
		, jumlahHalaman
		, deskripsiBuku
		, genre
		);
		Repository.saveObject(buku);
		return buku;
	}

    public Buku createBuku(Map<String, Object> requestBody, int id){
		String judulBuku = (String) vmjExchange.getRequestBodyForm("judulBuku");
		String penulis = (String) vmjExchange.getRequestBodyForm("penulis");
		String penerbit = (String) vmjExchange.getRequestBodyForm("penerbit");
		String jumlahHalamanStr = (String) vmjExchange.getRequestBodyForm("jumlahHalaman");
		int jumlahHalaman = Integer.parseInt(jumlahHalamanStr);
		String deskripsiBuku = (String) vmjExchange.getRequestBodyForm("deskripsiBuku");
		String genre = (String) vmjExchange.getRequestBodyForm("genre");
		
		//to do: fix association attributes
		
		Buku buku = BukuFactory.createBuku("LibraryManagementSystem.buku.core.BukuImpl", judulBuku, penulis, penerbit, jumlahHalaman, deskripsiBuku, genre);
		return buku;
	}

    public HashMap<String, Object> updateBuku(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBuku");
		int id = Integer.parseInt(idStr);
		Buku buku = Repository.getObject(id);
		
		buku.setJudulBuku((String) requestBody.get("judulBuku"));
		buku.setPenulis((String) requestBody.get("penulis"));
		buku.setPenerbit((String) requestBody.get("penerbit"));
		String jumlahHalamanStr = (String) requestBody.get("jumlahHalaman");
		buku.setJumlahHalaman(Integer.parseInt(jumlahHalamanStr));
		buku.setDeskripsiBuku((String) requestBody.get("deskripsiBuku"));
		buku.setGenre((String) requestBody.get("genre"));
		
		Repository.updateObject(buku);
		
		//to do: fix association attributes
		
		return buku.toHashMap();
		
	}

    public HashMap<String, Object> getBuku(Map<String, Object> requestBody){
		List<HashMap<String, Object>> bukuList = getAllBuku("buku_impl");
		for (HashMap<String, Object> buku : bukuList){
			int record_id = ((Double) buku.get("record_id")).intValue();
			if (record_id == id){
				return buku;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBukuById(int id){
		String idStr = vmjExchange.getGETParam("idBuku"); 
		int id = Integer.parseInt(idStr);
		Buku buku = bukuRepository.getObject(id);
		return buku.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Buku> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Buku> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBuku(requestBody);
	}

}
