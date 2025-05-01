package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class StatistikServiceComponent implements StatistikService{
	protected RepositoryUtil<Statistik> statistikRepository;

    public StatistikServiceComponent(){
        this.statistikRepository = new RepositoryUtil<Statistik>(LibraryManagementSystem.statistik.core.StatistikComponent.class);
    }	

    // public abstract HashMap<String, Object> getStatistik(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List);
    public abstract List<Buku> getListObject();
	public abstract int hitungTotalBuku();
}
