package LibraryManagementSystem.statistik.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Statistik {
	public BukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(BukuImpl daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
