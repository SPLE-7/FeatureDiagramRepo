package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface StatistikService {
	// HashMap<String, Object> getStatistik(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Statistik> List);
    List<Buku> getListObject();
}
