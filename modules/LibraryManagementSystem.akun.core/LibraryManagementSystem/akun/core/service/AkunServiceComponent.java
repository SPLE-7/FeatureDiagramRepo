package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AkunServiceComponent implements AkunService{
	protected RepositoryUtil<Akun> Repository;

    public AkunServiceComponent(){
        this.Repository = new RepositoryUtil<Akun>(LibraryManagementSystem.akun.core.AkunComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveAkun(VMJExchange vmjExchange);
    public abstract Akun createAkun(Map<String, Object> requestBodye);
	public abstract Akun createAkun(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateAkun(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAkun(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllAkun(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Akun> List);
    public abstract List<HashMap<String,Object>> deleteAkun(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAkunById(int id);

}
