package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BukuServiceDecorator extends BukuServiceComponent{
	protected BukuServiceComponent record;

    public BukuServiceDecorator(BukuServiceComponent record) {
        this.record = record;
    }

	public BukuImpl createBuku(Map<String, Object> requestBody){
		return record.createBuku(requestBody);
	}

    public Buku createBuku(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createBuku(requestBody, response);
	}

	public HashMap<String, Object> getBuku(Map<String, Object> requestBody){
		return record.getBuku(requestBody);
	}

	public List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody){
		return record.getAllBuku(requestBody);
	}

    public List<HashMap<String,Object>> saveBuku(VMJExchange vmjExchange){
		return record.saveBuku(vmjExchange);
	}

    public HashMap<String, Object> updateBuku(Map<String, Object> requestBody){
		return record.updateBuku(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Buku> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody){
		return record.deleteBuku(requestBody);
	}

	public HashMap<String, Object> getBukuById(int id){
        return record.getBukuById(id);
    }

}
