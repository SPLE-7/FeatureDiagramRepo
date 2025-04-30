package LibraryManagementSystem.daftarbuku.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="daftarbuku_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DaftarBukuComponent implements DaftarBuku{
	@Id
	protected UUID idBuku; 
	protected String judulBuku;
	protected String penulis;
	protected String penerbit;
	protected int jumlahHalaman;
	protected String deskripsiBuku;
	protected String genre;
	protected String objectName = DaftarBukuComponent.class.getName();

	public DaftarBukuComponent() {

	} 

	public DaftarBukuComponent(
        UUID idBuku, String judulBuku, String penulis, String penerbit, int jumlahHalaman, String deskripsiBuku, String genre
    ) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.jumlahHalaman = jumlahHalaman;
        this.deskripsiBuku = deskripsiBuku;
        this.genre = genre;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idBuku='" + getIdBuku() + "'" +
            " judulBuku='" + getJudulBuku() + "'" +
            " penulis='" + getPenulis() + "'" +
            " penerbit='" + getPenerbit() + "'" +
            " jumlahHalaman='" + getJumlahHalaman() + "'" +
            " deskripsiBuku='" + getDeskripsiBuku() + "'" +
            " genre='" + getGenre() + "'" +
            "}";
    }
	
}
