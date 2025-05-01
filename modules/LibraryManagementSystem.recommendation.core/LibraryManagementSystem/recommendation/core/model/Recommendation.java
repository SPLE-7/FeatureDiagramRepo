package LibraryManagementSystem.recommendation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Recommendation {
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	public User getAkunimpl();
	public void setAkunimpl(User akunimpl);
	HashMap<String, Object> toHashMap();
}
