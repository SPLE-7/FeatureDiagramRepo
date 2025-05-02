package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;
import com.google.gson.Gson;
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
import vmj.auth.annotations.Restricted;
import vmj.auth.model.core;
//add other required packages

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceComponent{

    public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody){
		String status = (String) requestBody.get("status");
		Buku daftarbukuimpl = bukuRepository.getObject(requestBody.get("idBuku"));
		// TODO: bingung nama id nya
		User akunimpl = userRepository.getObject(requestBody.get("id"));
		//to do: fix association attributes
		PeminjamanBuku peminjamanbuku = PeminjamanBukuFactory.createPeminjamanBuku(
			"LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl"
		, status
		, akunimpl
		, daftarbukuimpl
		, tanggalPeminjaman
		, tanggalPengembalian
		);
		Repository.saveObject(peminjamanbuku);
		return peminjamanbuku;
	}

    public HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody){
		List<HashMap<String, Object>> peminjamanbukuList = getAllPeminjamanBuku("peminjamanbuku_impl");
		for (HashMap<String, Object> peminjamanbuku : peminjamanbukuList){

			UUID recordId = UUID.fromString((String) peminjamanbuku.get("idPeminjamanBuku"));
			if (record_id.equals(requestBody.get("idPeminjamanBuku"))){
				return peminjamanbuku;
			}
		}
		return null;
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

}
