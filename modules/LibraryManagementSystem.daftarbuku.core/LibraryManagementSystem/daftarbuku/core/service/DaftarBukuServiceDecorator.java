package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class DaftarBukuServiceDecorator extends DaftarBukuServiceComponent{
	protected DaftarBukuServiceComponent record;

    public DaftarBukuServiceDecorator(DaftarBukuServiceComponent record) {
        this.record = record;
    }

	public DaftarBukuImpl createDaftarBuku(Map<String, Object> requestBody){
		return record.createDaftarBuku(requestBody);
	}

    public DaftarBuku createDaftarBuku(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createDaftarBuku(requestBody, response);
	}

	public HashMap<String, Object> getDaftarBuku(Map<String, Object> requestBody){
		return record.getDaftarBuku(requestBody);
	}

	public List<HashMap<String,Object>> getAllDaftarBuku(Map<String, Object> requestBody){
		return record.getAllDaftarBuku(requestBody);
	}

    public List<HashMap<String,Object>> saveDaftarBuku(VMJExchange vmjExchange){
		return record.saveDaftarBuku(vmjExchange);
	}

    public HashMap<String, Object> updateDaftarBuku(Map<String, Object> requestBody){
		return record.updateDaftarBuku(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<DaftarBuku> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteDaftarBuku(Map<String, Object> requestBody){
		return record.deleteDaftarBuku(requestBody);
	}

	public HashMap<String, Object> getDaftarBukuById(int id){
        return record.getDaftarBukuById(id);
    }

}
