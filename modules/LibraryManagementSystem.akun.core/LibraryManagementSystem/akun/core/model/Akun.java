package LibraryManagementSystem.akun.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Akun {
	public UUID getIdAkun();
	public void setIdAkun(UUID idAkun);
	public String getNama();
	public void setNama(String nama);
	HashMap<String, Object> toHashMap();
}
