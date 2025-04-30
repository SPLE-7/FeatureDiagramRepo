package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class StatistikResourceComponent implements StatistikResource{
	
	public StatistikResourceComponent() { }
 
    public abstract Statistik createStatistik(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateStatistik(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getStatistik(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteStatistik(VMJExchange vmjExchange);

	public abstract int hitungTotalBuku();
}
