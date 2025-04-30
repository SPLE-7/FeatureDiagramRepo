package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface StatistikService {
	Statistik createStatistik(Map<String, Object> requestBody);
	Statistik createStatistik(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getStatistik(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveStatistik(Map<String, Object> requestBody);
    HashMap<String, Object> updateStatistik(Map<String, Object> requestBody);
    HashMap<String, Object> getStatistikById(int id);
    List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteStatistik(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
