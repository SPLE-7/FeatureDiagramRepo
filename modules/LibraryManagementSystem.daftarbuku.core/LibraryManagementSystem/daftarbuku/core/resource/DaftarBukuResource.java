package LibraryManagementSystem.daftarbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface DaftarBukuResource {
    List<HashMap<String,Object>> saveDaftarBuku(VMJExchange vmjExchange);
    HashMap<String, Object> updateDaftarBuku(VMJExchange vmjExchange);
    HashMap<String, Object> getDaftarBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllDaftarBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteDaftarBuku(VMJExchange vmjExchange);
	HashMap<String, Object> createDaftarBuku(VMJExchange vmjExhange);
}
