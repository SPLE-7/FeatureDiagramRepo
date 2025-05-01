package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface StatistikResource {
    HashMap<String, Object> getStatistik(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange);
}
