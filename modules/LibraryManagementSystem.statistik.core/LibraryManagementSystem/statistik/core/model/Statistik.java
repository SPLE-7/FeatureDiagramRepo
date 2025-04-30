package LibraryManagementSystem.statistik.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Statistik {
	public DaftarBukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
