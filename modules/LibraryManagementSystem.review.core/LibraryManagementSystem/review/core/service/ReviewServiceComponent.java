package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewServiceComponent implements ReviewService{
	protected RepositoryUtil<Review> reviewRepository;
    protected RepositoryUtil<Buku> bukuRepository;
    protected RepositoryUtil<User> userRepository;

    public ReviewServiceComponent(){
        this.reviewRepository = new RepositoryUtil<Review>(LibraryManagementSystem.review.core.ReviewComponent.class);
        this.bukuRepository = new RepositoryUtil<Wishlist>(LibraryManagementSystem.buku.core.BukuComponent.class);
        this.userRepository = new RepositoryUtil<User>(LibraryManagementSystem.user.core.UserComponent.class);
    }	

    public abstract Review createReview(Map<String, Object> requestBodye);
    public abstract HashMap<String, Object> getReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Review> List);

}
