package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class DaftarBukuResourceDecorator extends DaftarBukuResourceComponent{
	protected DaftarBukuResourceComponent record;

    public DaftarBukuResourceDecorator(DaftarBukuResourceComponent record) {
        this.record = record;
    }

    public DaftarBuku createDaftarBuku(VMJExchange vmjExchange){
		return record.createDaftarBuku(vmjExchange);
	}

    public HashMap<String, Object> updateDaftarBuku(VMJExchange vmjExchange){
		return record.updateDaftarBuku(vmjExchange);
	}

    public HashMap<String, Object> getDaftarBuku(VMJExchange vmjExchange){
		return record.getDaftarBuku(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllDaftarBuku(VMJExchange vmjExchange){
		return record.getAllDaftarBuku(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteDaftarBuku(VMJExchange vmjExchange){
		return record.deleteDaftarBuku(vmjExchange);
	}

}
