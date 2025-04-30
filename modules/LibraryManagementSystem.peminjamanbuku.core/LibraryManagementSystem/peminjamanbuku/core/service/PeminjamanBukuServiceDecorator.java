package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PeminjamanBukuServiceDecorator extends PeminjamanBukuServiceComponent{
	protected PeminjamanBukuServiceComponent record;

    public PeminjamanBukuServiceDecorator(PeminjamanBukuServiceComponent record) {
        this.record = record;
    }

	public PeminjamanBukuImpl createPeminjamanBuku(Map<String, Object> requestBody){
		return record.createPeminjamanBuku(requestBody);
	}

    public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createPeminjamanBuku(requestBody, response);
	}

	public HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody){
		return record.getPeminjamanBuku(requestBody);
	}

	public List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody){
		return record.getAllPeminjamanBuku(requestBody);
	}

    public List<HashMap<String,Object>> savePeminjamanBuku(VMJExchange vmjExchange){
		return record.savePeminjamanBuku(vmjExchange);
	}

    public HashMap<String, Object> updatePeminjamanBuku(Map<String, Object> requestBody){
		return record.updatePeminjamanBuku(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePeminjamanBuku(Map<String, Object> requestBody){
		return record.deletePeminjamanBuku(requestBody);
	}

	public HashMap<String, Object> getPeminjamanBukuById(int id){
        return record.getPeminjamanBukuById(id);
    }

}
