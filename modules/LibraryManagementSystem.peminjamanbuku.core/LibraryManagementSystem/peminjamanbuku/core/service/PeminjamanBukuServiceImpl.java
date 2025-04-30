package LibraryManagementSystem.peminjamanbuku.core;
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
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceComponent{

    public List<HashMap<String,Object>> savePeminjamanBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PeminjamanBuku peminjamanbuku = createPeminjamanBuku(vmjExchange);
		peminjamanbukuRepository.saveObject(peminjamanbuku);
		return getAllPeminjamanBuku(vmjExchange);
	}

    public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody){
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		PeminjamanBuku PeminjamanBuku = PeminjamanBukuFactory.createPeminjamanBuku(
			"LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl",
		idPeminjamanBuku
		, status
		, akunimpl
		, daftarbukuimpl
		, tanggalPeminjaman
		, tanggalPengembalian
		);
		Repository.saveObject(peminjamanbuku);
		return peminjamanbuku;
	}

    public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody, int id){
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		PeminjamanBuku peminjamanbuku = PeminjamanBukuFactory.createPeminjamanBuku("LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl", status, akunimpl, daftarbukuimpl, tanggalPeminjaman, tanggalPengembalian);
		return peminjamanbuku;
	}

    public HashMap<String, Object> updatePeminjamanBuku(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPeminjamanBuku");
		int id = Integer.parseInt(idStr);
		PeminjamanBuku peminjamanbuku = Repository.getObject(id);
		
		peminjamanbuku.setStatus((String) requestBody.get("status"));
		
		Repository.updateObject(peminjamanbuku);
		
		//to do: fix association attributes
		
		return peminjamanbuku.toHashMap();
		
	}

    public HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody){
		List<HashMap<String, Object>> peminjamanbukuList = getAllPeminjamanBuku("peminjamanbuku_impl");
		for (HashMap<String, Object> peminjamanbuku : peminjamanbukuList){
			int record_id = ((Double) peminjamanbuku.get("record_id")).intValue();
			if (record_id == id){
				return peminjamanbuku;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPeminjamanBukuById(int id){
		String idStr = vmjExchange.getGETParam("idPeminjamanBuku"); 
		int id = Integer.parseInt(idStr);
		PeminjamanBuku peminjamanbuku = peminjamanbukuRepository.getObject(id);
		return peminjamanbuku.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<PeminjamanBuku> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePeminjamanBuku(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPeminjamanBuku(requestBody);
	}

}
