package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BukuService {
	Buku createBuku(Map<String, Object> requestBody);
	Buku createBuku(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveBuku(Map<String, Object> requestBody);
    HashMap<String, Object> updateBuku(Map<String, Object> requestBody);
    HashMap<String, Object> getBukuById(int id);
    List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
