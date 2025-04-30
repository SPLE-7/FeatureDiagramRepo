package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class DaftarBukuResourceComponent implements DaftarBukuResource{
	
	public DaftarBukuResourceComponent() { }
 
    public abstract DaftarBuku createDaftarBuku(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateDaftarBuku(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getDaftarBuku(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllDaftarBuku(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteDaftarBuku(VMJExchange vmjExchange);

}
