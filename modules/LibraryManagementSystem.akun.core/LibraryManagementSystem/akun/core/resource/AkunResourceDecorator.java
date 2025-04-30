package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AkunResourceDecorator extends AkunResourceComponent{
	protected AkunResourceComponent record;

    public AkunResourceDecorator(AkunResourceComponent record) {
        this.record = record;
    }

    public Akun createAkun(VMJExchange vmjExchange){
		return record.createAkun(vmjExchange);
	}

    public HashMap<String, Object> updateAkun(VMJExchange vmjExchange){
		return record.updateAkun(vmjExchange);
	}

    public HashMap<String, Object> getAkun(VMJExchange vmjExchange){
		return record.getAkun(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAkun(VMJExchange vmjExchange){
		return record.getAllAkun(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAkun(VMJExchange vmjExchange){
		return record.deleteAkun(vmjExchange);
	}

}
