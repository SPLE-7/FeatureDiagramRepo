package LibraryManagementSystem.buku.bukudigital;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuResourceDecorator;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuResourceComponent;

public class BukuResourceImpl extends BukuResourceDecorator {
    private BukuServiceImpl bukuServiceImpl;

	public BukuResourceImpl (BukuResourceComponent record) {
        super(record);
		this.bukuServiceImpl = new BukuServiceImpl(bukuServiceComponent);
    }

    // @Restriced(permission = "")
	@Route(url="call/bukudigital/create")
    public Buku create(VMJExchange vmjExchange){
		return bukuServiceImpl.getBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/bukudigital/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return bukuServiceImpl.getBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/bukudigital/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return bukuServiceImpl.getAllBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/bukudigital/delete")
    public List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bukuServiceImpl.deleteBuku(vmjExchange.getPayload());
	}

}
