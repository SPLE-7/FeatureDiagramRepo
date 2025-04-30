package LibraryManagementSystem.review.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Review {
	public UUID getIdReview();
	public void setIdReview(UUID idReview);
	public Date getPostedAt();
	public void setPostedAt(Date postedAt);
	public DaftarBukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
