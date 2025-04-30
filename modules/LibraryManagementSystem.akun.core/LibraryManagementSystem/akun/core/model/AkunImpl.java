package LibraryManagementSystem.akun.core;

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


@Entity(name="akun_impl")
@Table(name="akun_impl")
public class AkunImpl extends AkunComponent {

	public AkunImpl(UUID idAkun, String nama) {
		this.idAkun = idAkun;
		this.nama = nama;
	}

	public AkunImpl(String nama) {
		this.idAkun =  idAkun.randomUUID();;
		this.nama = nama;
	}

	public AkunImpl() { }

	public UUID getIdAkun() {
		return this.idAkun;
	}

	public void setIdAkun(UUID idAkun) {
		this.idAkun = idAkun;
	}
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> akunMap = new HashMap<String,Object>();
		akunMap.put("idAkun",getIdAkun());
		akunMap.put("nama",getNama());

        return akunMap;
    }

}
