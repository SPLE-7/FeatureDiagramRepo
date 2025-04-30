package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class StatistikServiceComponent implements StatistikService{
	protected RepositoryUtil<Statistik> Repository;

    public StatistikServiceComponent(){
        this.Repository = new RepositoryUtil<Statistik>(LibraryManagementSystem.statistik.core.StatistikComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveStatistik(VMJExchange vmjExchange);
    public abstract Statistik createStatistik(Map<String, Object> requestBodye);
	public abstract Statistik createStatistik(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateStatistik(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getStatistik(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List);
    public abstract List<HashMap<String,Object>> deleteStatistik(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getStatistikById(int id);

	public abstract int hitungTotalBuku();
}
