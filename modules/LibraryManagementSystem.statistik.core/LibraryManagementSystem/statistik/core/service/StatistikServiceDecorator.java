package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class StatistikServiceDecorator extends StatistikServiceComponent{
	protected StatistikServiceComponent record;

    public StatistikServiceDecorator(StatistikServiceComponent record) {
        this.record = record;
    }

	public StatistikImpl createStatistik(Map<String, Object> requestBody){
		return record.createStatistik(requestBody);
	}

    public Statistik createStatistik(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createStatistik(requestBody, response);
	}

	public HashMap<String, Object> getStatistik(Map<String, Object> requestBody){
		return record.getStatistik(requestBody);
	}

	public List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody){
		return record.getAllStatistik(requestBody);
	}

    public List<HashMap<String,Object>> saveStatistik(VMJExchange vmjExchange){
		return record.saveStatistik(vmjExchange);
	}

    public HashMap<String, Object> updateStatistik(Map<String, Object> requestBody){
		return record.updateStatistik(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteStatistik(Map<String, Object> requestBody){
		return record.deleteStatistik(requestBody);
	}

	public HashMap<String, Object> getStatistikById(int id){
        return record.getStatistikById(id);
    }

	public int hitungTotalBuku() {
		return record.hitungTotalBuku();
	}
}
