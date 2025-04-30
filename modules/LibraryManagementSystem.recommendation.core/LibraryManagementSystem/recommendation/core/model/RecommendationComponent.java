package LibraryManagementSystem.recommendation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="recommendation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RecommendationComponent implements Recommendation{
	@Id
	
	@ManyToOne(targetEntity=LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class)
	public DaftarBuku daftarbukuimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.wishlist.core.WishlistComponent.class)
	public Wishlist wishlistserviceimpl;
	protected String objectName = RecommendationComponent.class.getName();

	public RecommendationComponent() {

	} 

	public RecommendationComponent(
        DaftarBukuImpl daftarbukuimpl, AkunImpl akunimpl, WishlistImpl wishlistserviceimpl
    ) {
        this.daftarbukuimpl = daftarbukuimpl;
        this.akunimpl = akunimpl;
        this.wishlistserviceimpl = wishlistserviceimpl;
    }

	public abstract DaftarBukuImpl getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	
	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
	public abstract WishlistImpl getWishlistserviceimpl();
	public abstract void setWishlistserviceimpl(WishlistImpl wishlistserviceimpl);
	
 
	public abstract void getRecommendation();

	@Override
    public String toString() {
        return "{" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " wishlistserviceimpl='" + getWishlistserviceimpl() + "'" +
            "}";
    }
	
}
