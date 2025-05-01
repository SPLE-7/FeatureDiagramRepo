package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PeminjamanBukuServiceComponent implements PeminjamanBukuService{
	protected RepositoryUtil<PeminjamanBuku> peminjamanRepository;
    protected RepositoryUtil<Buku> bukuRepository;
    protected RepositoryUtil<User> userRepository;

    public PeminjamanBukuServiceComponent(){
        this.peminjamanRepository = new RepositoryUtil<PeminjamanBuku>(LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent.class);
        this.bukuRepository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
        this.userRepository = new RepositoryUtil<User>(LibraryManagementSystem.user.core.UserComponent.class);
    }	

    public abstract PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBodye);
    public abstract HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List);

}
