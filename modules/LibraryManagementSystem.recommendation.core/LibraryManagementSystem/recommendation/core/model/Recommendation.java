package LibraryManagementSystem.recommendation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Recommendation {
	public DaftarBukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	public AkunImpl getAkunimpl();
	public void setAkunimpl(AkunImpl akunimpl);
	public WishlistImpl getWishlistserviceimpl();
	public void setWishlistserviceimpl(WishlistImpl wishlistserviceimpl);
	HashMap<String, Object> toHashMap();
}
