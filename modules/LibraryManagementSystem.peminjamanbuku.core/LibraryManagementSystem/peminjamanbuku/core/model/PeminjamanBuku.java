package LibraryManagementSystem.peminjamanbuku.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface PeminjamanBuku {
	public UUID getIdPeminjamanBuku();
	public void setIdPeminjamanBuku(UUID idPeminjamanBuku);
	public String getStatus();
	public void setStatus(String status);
	public AkunImpl getAkunimpl();
	public void setAkunimpl(AkunImpl akunimpl);
	public BukuImpl getDaftarbukuimpl();
	public void setDaftarbukuimpl(BukuImpl daftarbukuimpl);
	public Date getTanggalPeminjaman();
	public void setTanggalPeminjaman(Date tanggalPeminjaman);
	public Date getTanggalPengembalian();
	public void setTanggalPengembalian(Date tanggalPengembalian);
	HashMap<String, Object> toHashMap();
}
