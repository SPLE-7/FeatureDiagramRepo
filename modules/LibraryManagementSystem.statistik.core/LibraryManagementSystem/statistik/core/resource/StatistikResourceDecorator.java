package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class StatistikResourceDecorator extends StatistikResourceComponent{
	protected StatistikResourceComponent record;

    public StatistikResourceDecorator(StatistikResourceComponent record) {
        this.record = record;
    }

    public Statistik createStatistik(VMJExchange vmjExchange){
		return record.createStatistik(vmjExchange);
	}

    public HashMap<String, Object> updateStatistik(VMJExchange vmjExchange){
		return record.updateStatistik(vmjExchange);
	}

    public HashMap<String, Object> getStatistik(VMJExchange vmjExchange){
		return record.getStatistik(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange){
		return record.getAllStatistik(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteStatistik(VMJExchange vmjExchange){
		return record.deleteStatistik(vmjExchange);
	}

	public int hitungTotalBuku() {
		return record.hitungTotalBuku();
	}
}
