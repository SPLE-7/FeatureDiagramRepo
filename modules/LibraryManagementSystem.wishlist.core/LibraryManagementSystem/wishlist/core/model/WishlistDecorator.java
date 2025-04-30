package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlistDecorator extends WishlistComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlistComponent record;

	public WishlistDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public WishlistDecorator (WishlistComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public WishlistDecorator (, WishlistComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public WishlistDecorator (WishlistComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public WishlistDecorator() { }


	public void addBookToWishlist() {
		return record.addBookToWishlist();
	}

	public void removeBookFromWishlist() {
		return record.removeBookFromWishlist();
	}

	public void getWishlist() {
		return record.getWishlist();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
