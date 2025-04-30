package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AkunServiceDecorator extends AkunServiceComponent{
	protected AkunServiceComponent record;

    public AkunServiceDecorator(AkunServiceComponent record) {
        this.record = record;
    }

	public AkunImpl createAkun(Map<String, Object> requestBody){
		return record.createAkun(requestBody);
	}

    public Akun createAkun(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createAkun(requestBody, response);
	}

	public HashMap<String, Object> getAkun(Map<String, Object> requestBody){
		return record.getAkun(requestBody);
	}

	public List<HashMap<String,Object>> getAllAkun(Map<String, Object> requestBody){
		return record.getAllAkun(requestBody);
	}

    public List<HashMap<String,Object>> saveAkun(VMJExchange vmjExchange){
		return record.saveAkun(vmjExchange);
	}

    public HashMap<String, Object> updateAkun(Map<String, Object> requestBody){
		return record.updateAkun(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Akun> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAkun(Map<String, Object> requestBody){
		return record.deleteAkun(requestBody);
	}

	public HashMap<String, Object> getAkunById(int id){
        return record.getAkunById(id);
    }

}
