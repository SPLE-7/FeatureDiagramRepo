package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BukuServiceComponent implements BukuService{
	protected RepositoryUtil<Buku> Repository;

    public BukuServiceComponent(){
        this.Repository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveBuku(VMJExchange vmjExchange);
    public abstract Buku createBuku(Map<String, Object> requestBodye);
	public abstract Buku createBuku(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateBuku(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Buku> List);
    public abstract List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBukuById(int id);

}
