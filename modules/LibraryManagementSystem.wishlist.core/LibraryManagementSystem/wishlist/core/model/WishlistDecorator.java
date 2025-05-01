package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlistDecorator extends WishlistComponent {
    @OneToOne(cascade = CascadeType.ALL)
    protected WishlistComponent record;

    protected UUID id = UUID.randomUUID();

    public WishlistDecorator() {
        super();
    }

    public WishlistDecorator(WishlistComponent record) {
        super();
        this.record = record;
    }

    public WishlistDecorator(WishlistComponent record, String objectName) {
        super();
        this.record = record;
        this.objectName = objectName;
    }

    public void addBookToWishlist() {
        record.addBookToWishlist();
    }

    public void removeBookFromWishlist() {
        record.removeBookFromWishlist();
    }

    public void getWishlist() {
        record.getWishlist();
    }

    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
