package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class DaftarBukuServiceComponent implements DaftarBukuService{
	protected RepositoryUtil<DaftarBuku> Repository;

    public DaftarBukuServiceComponent(){
        this.Repository = new RepositoryUtil<DaftarBuku>(LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveDaftarBuku(VMJExchange vmjExchange);
    public abstract DaftarBuku createDaftarBuku(Map<String, Object> requestBodye);
	public abstract DaftarBuku createDaftarBuku(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateDaftarBuku(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getDaftarBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllDaftarBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<DaftarBuku> List);
    public abstract List<HashMap<String,Object>> deleteDaftarBuku(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getDaftarBukuById(int id);

}
