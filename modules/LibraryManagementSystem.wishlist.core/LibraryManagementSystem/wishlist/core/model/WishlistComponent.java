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
	
	@ManyToOne(targetEntity=LibraryManagementSystem.user.core.UserComponent.class)
	public User akunimpl;
	public Buku daftarbukuimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.user.core.UserComponent.class)
	public User akunimpl;
	public User akunimpl;
	protected String objectName = WishlistComponent.class.getName();

	public WishlistComponent() {

	} 

	public WishlistComponent(
        UserImpl akunimpl, Buku daftarbukuimpl, UserImpl akunimpl, User akunimpl
    ) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.akunimpl = akunimpl;
        this.akunimpl = akunimpl;
    }

	public abstract UserImpl getAkunimpl();
	public abstract void setAkunimpl(UserImpl akunimpl);
	
	public abstract Buku getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(Buku daftarbukuimpl);
	
	public abstract UserImpl getAkunimpl();
	public abstract void setAkunimpl(UserImpl akunimpl);
	
	public abstract User getAkunimpl();
	public abstract void setAkunimpl(User akunimpl);
	
 
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
