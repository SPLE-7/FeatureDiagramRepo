package LibraryManagementSystem.akun.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AkunResource {
    List<HashMap<String,Object>> saveAkun(VMJExchange vmjExchange);
    HashMap<String, Object> updateAkun(VMJExchange vmjExchange);
    HashMap<String, Object> getAkun(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAkun(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAkun(VMJExchange vmjExchange);
	HashMap<String, Object> createAkun(VMJExchange vmjExhange);
}
