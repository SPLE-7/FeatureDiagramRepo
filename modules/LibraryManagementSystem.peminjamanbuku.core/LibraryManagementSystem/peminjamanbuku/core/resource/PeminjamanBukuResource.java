package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PeminjamanBukuResource {
    List<HashMap<String,Object>> savePeminjamanBuku(VMJExchange vmjExchange);
    HashMap<String, Object> updatePeminjamanBuku(VMJExchange vmjExchange);
    HashMap<String, Object> getPeminjamanBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPeminjamanBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePeminjamanBuku(VMJExchange vmjExchange);
	HashMap<String, Object> createPeminjamanBuku(VMJExchange vmjExhange);
}
