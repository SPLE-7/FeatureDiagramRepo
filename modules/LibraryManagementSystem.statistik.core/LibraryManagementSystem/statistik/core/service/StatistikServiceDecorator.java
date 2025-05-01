package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class StatistikServiceDecorator extends StatistikServiceComponent{
	protected StatistikServiceComponent record;

    public StatistikServiceDecorator(StatistikServiceComponent record) {
        this.record = record;
    }

	// public HashMap<String, Object> getStatistik(Map<String, Object> requestBody){
	// 	return record.getStatistik(requestBody);
	// }

	public List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody){
		return record.getAllStatistik(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List){
		return record.transformListToHashMap(List);
	}

	public int hitungTotalBuku() {
		return record.hitungTotalBuku();
	}

	public List<Buku> getListObject() {
        return record.getListObject();
    }
}
