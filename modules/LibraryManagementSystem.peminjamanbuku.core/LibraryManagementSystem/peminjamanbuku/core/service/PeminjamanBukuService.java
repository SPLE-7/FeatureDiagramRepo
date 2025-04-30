package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PeminjamanBukuService {
	PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody);
	PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> savePeminjamanBuku(Map<String, Object> requestBody);
    HashMap<String, Object> updatePeminjamanBuku(Map<String, Object> requestBody);
    HashMap<String, Object> getPeminjamanBukuById(int id);
    List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deletePeminjamanBuku(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
