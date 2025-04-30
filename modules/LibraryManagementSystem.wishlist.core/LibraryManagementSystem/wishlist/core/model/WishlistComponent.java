package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistComponent implements Wishlist{
	@Id
	
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class)
	public DaftarBuku daftarbukuimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	protected String objectName = WishlistComponent.class.getName();

	public WishlistComponent() {

	} 

	public WishlistComponent(
        AkunImpl akunimpl, DaftarBukuImpl daftarbukuimpl, AkunImpl akunimpl, AkunImpl akunimpl
    ) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.akunimpl = akunimpl;
        this.akunimpl = akunimpl;
    }

	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
	public abstract DaftarBukuImpl getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	
	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
 
	public abstract void addBookToWishlist();

	public abstract void removeBookFromWishlist();

	public abstract void getWishlist();

	@Override
    public String toString() {
        return "{" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            "}";
    }
	
}
