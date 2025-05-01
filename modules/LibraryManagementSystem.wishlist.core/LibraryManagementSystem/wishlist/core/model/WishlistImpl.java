package LibraryManagementSystem.wishlist.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name = "wishlist_impl")
@Table(name = "wishlist_impl")
public class WishlistImpl extends WishlistComponent {

    public WishlistImpl(AkunImpl akunimpl, BukuImpl daftarbukuimpl) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.id = UUID.randomUUID();
    }

    public WishlistImpl() {
        this.id = UUID.randomUUID();
    }

    @Override
    public void addBookToWishlist() {
        // TODO: implement this method
    }

    @Override
    public void removeBookFromWishlist() {
        // TODO: implement this method
    }

    @Override
    public void getWishlist() {
        // TODO: implement this method
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistMap = new HashMap<>();
        wishlistMap.put("akunimpl", getAkunimpl());
        wishlistMap.put("daftarbukuimpl", getDaftarbukuimpl());
        return wishlistMap;
    }
}
