package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PeminjamanBukuServiceComponent implements PeminjamanBukuService{
	protected RepositoryUtil<PeminjamanBuku> Repository;

    public PeminjamanBukuServiceComponent(){
        this.Repository = new RepositoryUtil<PeminjamanBuku>(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent.class);
    }	

    public abstract List<HashMap<String,Object>> savePeminjamanBuku(VMJExchange vmjExchange);
    public abstract PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBodye);
	public abstract PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updatePeminjamanBuku(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List);
    public abstract List<HashMap<String,Object>> deletePeminjamanBuku(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPeminjamanBukuById(int id);

}
