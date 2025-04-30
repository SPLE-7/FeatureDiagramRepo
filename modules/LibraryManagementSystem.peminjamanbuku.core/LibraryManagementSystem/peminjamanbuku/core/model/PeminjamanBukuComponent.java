package LibraryManagementSystem.peminjamanbuku.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="peminjamanbuku_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PeminjamanBukuComponent implements PeminjamanBuku{
	@Id
	protected UUID idPeminjamanBuku; 
	protected String status;
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class)
	public DaftarBuku daftarbukuimpl;
	protected Date tanggalPeminjaman;
	protected Date tanggalPengembalian;
	protected String objectName = PeminjamanBukuComponent.class.getName();

	public PeminjamanBukuComponent() {

	} 

	public PeminjamanBukuComponent(
        UUID idPeminjamanBuku, String status, AkunImpl akunimpl, DaftarBukuImpl daftarbukuimpl, Date tanggalPeminjaman, Date tanggalPengembalian
    ) {
        this.idPeminjamanBuku = idPeminjamanBuku;
        this.status = status;
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
    }

	public UUID getIdPeminjamanBuku() {
		return this.idPeminjamanBuku;
	}

	public void setIdPeminjamanBuku(UUID idPeminjamanBuku) {
		this.idPeminjamanBuku = idPeminjamanBuku;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
	public abstract DaftarBukuImpl getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	
	public Date getTanggalPeminjaman() {
		return this.tanggalPeminjaman;
	}

	public void setTanggalPeminjaman(Date tanggalPeminjaman) {
		this.tanggalPeminjaman = tanggalPeminjaman;
	}
	public Date getTanggalPengembalian() {
		return this.tanggalPengembalian;
	}

	public void setTanggalPengembalian(Date tanggalPengembalian) {
		this.tanggalPengembalian = tanggalPengembalian;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idPeminjamanBuku='" + getIdPeminjamanBuku() + "'" +
            " status='" + getStatus() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " tanggalPeminjaman='" + getTanggalPeminjaman() + "'" +
            " tanggalPengembalian='" + getTanggalPengembalian() + "'" +
            "}";
    }
	
}
