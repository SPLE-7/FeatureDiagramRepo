package LibraryManagementSystem.recommendation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Recommendation {
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	public UserImpl getAkunimpl();
	public void setAkunimpl(UserImpl akunimpl);
	HashMap<String, Object> toHashMap();
}
