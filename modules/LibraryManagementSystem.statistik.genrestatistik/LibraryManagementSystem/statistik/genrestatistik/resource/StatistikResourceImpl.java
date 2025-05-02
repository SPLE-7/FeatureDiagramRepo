package LibraryManagementSystem.statistik.genrestatistik;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikResourceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.statistik.core.StatistikResourceComponent;

public class StatistikResourceImpl extends StatistikResourceDecorator {
    private StatistikServiceImpl statistikServiceImpl;
	public StatistikResourceImpl (StatistikResourceComponent record, StatistikServiceImpl statistikServiceImpl) {
        super(record);
		this.statistikServiceImpl = statistikServiceImpl;
    }

	// @Restriced(permission = "")
    // @Route(url="call/genrestatistik/detail")
    // public HashMap<String, Object> get(VMJExchange vmjExchange){
	// 	return record.getStatistik(vmjExchange);
	// }

	// @Restriced(permission = "")
    @Route(url="call/genrestatistik/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return statistikServiceImpl.getAllStatistik(vmjExchange.getPayload());
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
	}
}
