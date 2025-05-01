package LibraryManagementSystem.wishlist.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Wishlist {
	public UserImpl getAkunimpl();
	public void setAkunimpl(UserImpl akunimpl);
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	public UserImpl getAkunimpl();
	public void setAkunimpl(UserImpl akunimpl);
	public User getAkunimpl();
	public void setAkunimpl(User akunimpl);
	HashMap<String, Object> toHashMap();
}
