package LibraryManagementSystem.wishlist.wishlistwithstatus;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistResourceDecorator;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.core.WishlistResourceComponent;

public class WishlistResourceImpl extends WishlistResourceDecorator {
    public WishlistResourceImpl (WishlistResourceComponent record) {
        super(record);
    }

	// TODO: BELOM SEMUA
    // @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Wishlist create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.wishlistwithstatus.core.WishlistImpl", , status);
			return deco;
	}

    public Wishlist create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("LibraryManagementSystem.wishlistwithstatus.core.WishlistImpl", id, , status);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getWishlist(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithstatus/delete")
    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void updateStatus(UUID bookId, String newStatus) {
		// TODO: implement this method
	}
}
