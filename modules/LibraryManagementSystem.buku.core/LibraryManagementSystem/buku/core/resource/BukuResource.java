package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BukuResource {
    List<HashMap<String,Object>> saveBuku(VMJExchange vmjExchange);
    HashMap<String, Object> updateBuku(VMJExchange vmjExchange);
    HashMap<String, Object> getBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange);
	HashMap<String, Object> createBuku(VMJExchange vmjExhange);
}
