package LibraryManagementSystem.daftarbuku.core;

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


@Entity(name="daftarbuku_impl")
@Table(name="daftarbuku_impl")
public class DaftarBukuImpl extends DaftarBukuComponent {

	public DaftarBukuImpl(UUID idBuku, String judulBuku, String penulis, String penerbit, int jumlahHalaman, String deskripsiBuku, String genre) {
		this.idBuku = idBuku;
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.jumlahHalaman = jumlahHalaman;
		this.deskripsiBuku = deskripsiBuku;
		this.genre = genre;
	}

	public DaftarBukuImpl(String judulBuku, String penulis, String penerbit, int jumlahHalaman, String deskripsiBuku, String genre) {
		this.idBuku =  idBuku.randomUUID();;
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.jumlahHalaman = jumlahHalaman;
		this.deskripsiBuku = deskripsiBuku;
		this.genre = genre;
	}

	public DaftarBukuImpl() { }

	public UUID getIdBuku() {
		return this.idBuku;
	}

	public void setIdBuku(UUID idBuku) {
		this.idBuku = idBuku;
	}
	public String getJudulBuku() {
		return this.judulBuku;
	}

	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}
	public String getPenulis() {
		return this.penulis;
	}

	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}
	public String getPenerbit() {
		return this.penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	public int getJumlahHalaman() {
		return this.jumlahHalaman;
	}

	public void setJumlahHalaman(int jumlahHalaman) {
		this.jumlahHalaman = jumlahHalaman;
	}
	public String getDeskripsiBuku() {
		return this.deskripsiBuku;
	}

	public void setDeskripsiBuku(String deskripsiBuku) {
		this.deskripsiBuku = deskripsiBuku;
	}
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> daftarbukuMap = new HashMap<String,Object>();
		daftarbukuMap.put("idBuku",getIdBuku());
		daftarbukuMap.put("judulBuku",getJudulBuku());
		daftarbukuMap.put("penulis",getPenulis());
		daftarbukuMap.put("penerbit",getPenerbit());
		daftarbukuMap.put("jumlahHalaman",getJumlahHalaman());
		daftarbukuMap.put("deskripsiBuku",getDeskripsiBuku());
		daftarbukuMap.put("genre",getGenre());

        return daftarbukuMap;
    }

}
