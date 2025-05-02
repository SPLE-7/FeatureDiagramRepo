package LibraryManagementSystem.peminjamanbuku.renewal;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceComponent;

public class PeminjamanBukuResourceImpl extends PeminjamanBukuResourceDecorator {
    private PeminjamanBukuServiceImpl peminjamanBukuServiceImpl;

	public PeminjamanBukuResourceImpl (PeminjamanBukuResourceComponent record, PeminjamanBukuServiceImpl peminjamanBukuServiceImpl) {
        super(record);
		this.peminjamanBukuServiceImpl = peminjamanBukuServiceImpl;
    }

	@Route(url="call/renewal/create")
    public PeminjamanBuku create(VMJExchange vmjExchange){
		String renewalCountStr = (String) vmjExchange.getRequestBodyForm("renewalCount");
		int renewalCount = Integer.parseInt(renewalCountStr);
		
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return peminjamanBukuServiceImpl.createPeminjamanBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/renewal/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return peminjamanBukuServiceImpl.getPeminjamanBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/renewal/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return peminjamanBukuServiceImpl.getAllPeminjamanBuku(vmjExchange.getPayload());
	}

	public boolean RequestRenewal() {
		// TODO: implement this method
	}
}
