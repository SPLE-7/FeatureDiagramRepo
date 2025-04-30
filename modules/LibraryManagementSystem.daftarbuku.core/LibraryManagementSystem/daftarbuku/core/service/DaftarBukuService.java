package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface DaftarBukuService {
	DaftarBuku createDaftarBuku(Map<String, Object> requestBody);
	DaftarBuku createDaftarBuku(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getDaftarBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveDaftarBuku(Map<String, Object> requestBody);
    HashMap<String, Object> updateDaftarBuku(Map<String, Object> requestBody);
    HashMap<String, Object> getDaftarBukuById(int id);
    List<HashMap<String,Object>> getAllDaftarBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteDaftarBuku(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
