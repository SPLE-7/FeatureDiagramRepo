package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AkunResourceComponent implements AkunResource{
	
	public AkunResourceComponent() { }
 
    public abstract Akun createAkun(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateAkun(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAkun(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAkun(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAkun(VMJExchange vmjExchange);

}
