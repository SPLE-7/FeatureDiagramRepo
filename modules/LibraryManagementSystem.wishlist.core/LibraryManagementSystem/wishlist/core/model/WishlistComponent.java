package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistComponent implements Wishlist {
    @Id
    @GeneratedValue
    private UUID id;

	// TODO: Import external library 
    @ManyToOne(targetEntity = LibraryManagementSystem.user.core.UserComponent.class)
    public User akunimpl;

    @ManyToOne(targetEntity = LibraryManagementSystem.buku.core.BukuComponent.class)
    public Buku daftarbukuimpl;

    protected String objectName = WishlistComponent.class.getName();

    public WishlistComponent() {}

    public WishlistComponent(User akunimpl, Buku daftarbukuimpl) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
    }

    public abstract User getAkunimpl();
    public abstract void setAkunimpl(User akunimpl);

    public abstract Buku getDaftarbukuimpl();
    public abstract void setDaftarbukuimpl(Buku daftarbukuimpl);

    public abstract void addBookToWishlist();
    public abstract void removeBookFromWishlist();
    public abstract void getWishlist();

    @Override
    public String toString() {
        return "{" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
}