package LibraryManagementSystem.recommendation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Recommendation {
	public BukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(BukuImpl daftarbukuimpl);
	public AkunImpl getAkunimpl();
	public void setAkunimpl(AkunImpl akunimpl);
	HashMap<String, Object> toHashMap();
}
