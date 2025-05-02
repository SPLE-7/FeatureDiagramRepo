package LibraryManagementSystem.wishlist.wishlistwithstatus;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistResourceDecorator;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.core.WishlistResourceComponent;

public class WishlistResourceImpl extends WishlistResourceDecorator {
    private WishlistServiceImpl wishlistServiceImpl;
	public WishlistResourceImpl (WishlistResourceComponent record, WishlistServiceImpl wishlistServiceImpl) {
        super(record);
		this.wishlistServiceImpl = wishlistServiceImpl;
    }

	@Route(url="call/wishlistwithstatus/create")
    public Wishlist create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return wishlistServiceImpl.createWishlist(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return wishlistServiceImpl.getWishlist(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return wishlistServiceImpl.getAllWishlist(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/delete")
    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlistServiceImpl.deleteWishlist(vmjExchange.getPayload());
	}

	public void updateStatus(UUID bookId, String newStatus) {
		// TODO: implement this method
	}
}
