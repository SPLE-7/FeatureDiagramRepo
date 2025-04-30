package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AkunService {
	Akun createAkun(Map<String, Object> requestBody);
	Akun createAkun(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getAkun(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveAkun(Map<String, Object> requestBody);
    HashMap<String, Object> updateAkun(Map<String, Object> requestBody);
    HashMap<String, Object> getAkunById(int id);
    List<HashMap<String,Object>> getAllAkun(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteAkun(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
