package librarymanagementsystem.product.default;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vmj.routing.route.VMJCors;
import vmj.routing.route.VMJServer;
import vmj.routing.route.Router;
import vmj.hibernate.integrator.HibernateUtil;
import org.hibernate.cfg.Configuration;

import vmj.auth.model.UserResourceFactory;
import vmj.auth.model.RoleResourceFactory;
import vmj.auth.model.core.UserResource;
import vmj.auth.model.core.RoleResource;

import LibraryManagementSystem.daftarbuku.DaftarBukuResourceFactory;
import LibraryManagementSystem.daftarbuku.core.DaftarBukuResource;
import LibraryManagementSystem.daftarbuku.DaftarBukuServiceFactory;
import LibraryManagementSystem.daftarbuku.core.DaftarBukuService;
import LibraryManagementSystem.statistik.StatistikResourceFactory;
import LibraryManagementSystem.statistik.core.StatistikResource;
import LibraryManagementSystem.statistik.StatistikServiceFactory;
import LibraryManagementSystem.statistik.core.StatistikService;
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuResourceFactory;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResource;
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuServiceFactory;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuService;
import LibraryManagementSystem.review.ReviewResourceFactory;
import LibraryManagementSystem.review.core.ReviewResource;
import LibraryManagementSystem.review.ReviewServiceFactory;
import LibraryManagementSystem.review.core.ReviewService;
import LibraryManagementSystem.wishlist.WishlistServiceResourceFactory;
import LibraryManagementSystem.wishlist.core.WishlistServiceResource;
import LibraryManagementSystem.wishlist.WishlistServiceServiceFactory;
import LibraryManagementSystem.wishlist.core.WishlistServiceService;

public class Default {

	public static void main(String[] args) {

		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(vmj.auth.model.core.Role.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRole.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.User.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.passworded.UserImpl.class);

		configuration.addAnnotatedClass(LibraryManagementSystem.daftarbuku.core.DaftarBuku.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.daftarbuku.core.DaftarBukuDecorator.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.daftarbuku.core.DaftarBukuImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.daftarbuku.bukufisik.DaftarBukuImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.statistik.core.Statistik.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.statistik.core.StatistikComponent.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.statistik.core.StatistikDecorator.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.statistik.core.StatistikImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.statistik.genrestatistik.StatistikImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBuku.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuDecorator.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.review.core.Review.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.review.core.ReviewComponent.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.review.core.ReviewDecorator.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.review.core.ReviewImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.review.reviewkomentar.ReviewImpl.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.wishlist.core.WishlistService.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.wishlist.core.WishlistServiceComponent.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.wishlist.core.WishlistServiceDecorator.class);
		configuration.addAnnotatedClass(LibraryManagementSystem.wishlist.core.WishlistServiceImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		HibernateUtil.buildSessionFactory(configuration);

		createObjectsAndBindEndPoints();
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("vmj.auth.model.core.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("vmj.auth.model.core.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("vmj.auth.model.passworded.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("vmj.auth.model.core.UserResourceImpl"));

        DaftarBukuService daftarbukuDaftarBuku2Service = DaftarBukuServiceFactory
            .createDaftarBukuService("LibraryManagementSystem.daftarbuku.core.DaftarBukuServiceImpl"
            	);		

        DaftarBukuResource daftarbukuDaftarBuku2Resource = DaftarBukuResourceFactory
            .createDaftarBukuResource("LibraryManagementSystem.daftarbuku.core.DaftarBukuResourceImpl"
                );
			
        DaftarBukuService bukufisikDaftarBuku2Service = DaftarBukuServiceFactory
            .createDaftarBukuService("LibraryManagementSystem.daftarbuku.bukufisik.DaftarBukuServiceImpl"
            	, daftarbukuDaftarBuku2Service);		

        DaftarBukuResource bukufisikDaftarBuku2Resource = DaftarBukuResourceFactory
            .createDaftarBukuResource("LibraryManagementSystem.daftarbuku.bukufisik.DaftarBukuResourceImpl"
                , daftarbukuDaftarBuku2Resource, daftarbukuDaftarBuku2Service);
			
        StatistikService statistikStatistik2Service = StatistikServiceFactory
            .createStatistikService("LibraryManagementSystem.statistik.core.StatistikServiceImpl"
            	);		

        StatistikResource statistikStatistik2Resource = StatistikResourceFactory
            .createStatistikResource("LibraryManagementSystem.statistik.core.StatistikResourceImpl"
                );
			
        StatistikService genrestatistikStatistik2Service = StatistikServiceFactory
            .createStatistikService("LibraryManagementSystem.statistik.genrestatistik.StatistikServiceImpl"
            	, statistikStatistik2Service);		

        StatistikResource genrestatistikStatistik2Resource = StatistikResourceFactory
            .createStatistikResource("LibraryManagementSystem.statistik.genrestatistik.StatistikResourceImpl"
                , statistikStatistik2Resource, statistikStatistik2Service);
			
        PeminjamanBukuService peminjamanbukuPeminjamanBuku2Service = PeminjamanBukuServiceFactory
            .createPeminjamanBukuService("LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceImpl"
            	);		

        PeminjamanBukuResource peminjamanbukuPeminjamanBuku2Resource = PeminjamanBukuResourceFactory
            .createPeminjamanBukuResource("LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceImpl"
                );
			
        ReviewService reviewReview2Service = ReviewServiceFactory
            .createReviewService("LibraryManagementSystem.review.core.ReviewServiceImpl"
            	);		

        ReviewResource reviewReview2Resource = ReviewResourceFactory
            .createReviewResource("LibraryManagementSystem.review.core.ReviewResourceImpl"
                );
			
        ReviewService reviewkomentarReview2Service = ReviewServiceFactory
            .createReviewService("LibraryManagementSystem.review.reviewkomentar.ReviewServiceImpl"
            	, reviewReview2Service);		

        ReviewResource reviewkomentarReview2Resource = ReviewResourceFactory
            .createReviewResource("LibraryManagementSystem.review.reviewkomentar.ReviewResourceImpl"
                , reviewReview2Resource, reviewReview2Service);
			
        WishlistServiceService wishlistWishlist2Service = WishlistServiceServiceFactory
            .createWishlistServiceService("LibraryManagementSystem.wishlist.core.WishlistServiceServiceImpl"
            	);		

        WishlistServiceResource wishlistWishlistService2Resource = WishlistServiceResourceFactory
            .createWishlistServiceResource("LibraryManagementSystem.wishlist.core.WishlistServiceResourceImpl"
                );
			

		System.out.println("wishlistWishlistService2Resource endpoints binding");
		Router.route(wishlistWishlistService2Resource);
		
		System.out.println("wishlistWishlist2Service endpoints binding");
		Router.route(wishlistWishlist2Service);
		
		System.out.println("reviewkomentarReview2Resource endpoints binding");
		Router.route(reviewkomentarReview2Resource);
		
		System.out.println("reviewkomentarReview2Service endpoints binding");
		Router.route(reviewkomentarReview2Service);
		
		System.out.println("reviewReview2Resource endpoints binding");
		Router.route(reviewReview2Resource);
		
		System.out.println("reviewReview2Service endpoints binding");
		Router.route(reviewReview2Service);
		
		System.out.println("peminjamanbukuPeminjamanBuku2Resource endpoints binding");
		Router.route(peminjamanbukuPeminjamanBuku2Resource);
		
		System.out.println("peminjamanbukuPeminjamanBuku2Service endpoints binding");
		Router.route(peminjamanbukuPeminjamanBuku2Service);
		
		System.out.println("genrestatistikStatistik2Resource endpoints binding");
		Router.route(genrestatistikStatistik2Resource);
		
		System.out.println("genrestatistikStatistik2Service endpoints binding");
		Router.route(genrestatistikStatistik2Service);
		
		System.out.println("statistikStatistik2Resource endpoints binding");
		Router.route(statistikStatistik2Resource);
		
		System.out.println("statistikStatistik2Service endpoints binding");
		Router.route(statistikStatistik2Service);
		
		System.out.println("bukufisikDaftarBuku2Resource endpoints binding");
		Router.route(bukufisikDaftarBuku2Resource);
		
		System.out.println("bukufisikDaftarBuku2Service endpoints binding");
		Router.route(bukufisikDaftarBuku2Service);
		
		System.out.println("daftarbukuDaftarBuku2Resource endpoints binding");
		Router.route(daftarbukuDaftarBuku2Resource);
		
		System.out.println("daftarbukuDaftarBuku2Service endpoints binding");
		Router.route(daftarbukuDaftarBuku2Service);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class.getName()
				});
				put("deltas", new String[] {
					LibraryManagementSystem.daftarbuku.bukufisik.DaftarBukuImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            LibraryManagementSystem.statistik.core.StatistikComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					LibraryManagementSystem.statistik.core.StatistikComponent.class.getName()
				});
				put("deltas", new String[] {
					LibraryManagementSystem.statistik.genrestatistik.StatistikImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            LibraryManagementSystem.review.core.ReviewComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					LibraryManagementSystem.review.core.ReviewComponent.class.getName()
				});
				put("deltas", new String[] {
					LibraryManagementSystem.review.reviewkomentar.ReviewImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            LibraryManagementSystem.wishlist.core.WishlistServiceComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					LibraryManagementSystem.wishlist.core.WishlistServiceComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }

	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        } catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			System.out.println("Buat file cors.properties terlebih dahulu pada src-gen/(namaProduk) dengan contoh sebagai berikut:");
			System.out.println("allowedMethod = GET, POST");
			System.out.println("allowedOrigin = http://example.com");
        }
    }


}