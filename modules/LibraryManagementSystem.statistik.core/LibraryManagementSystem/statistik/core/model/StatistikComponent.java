package LibraryManagementSystem.statistik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="statistik_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StatistikComponent implements Statistik{
	@Id
	
	@ManyToOne(targetEntity=LibraryManagementSystem.daftarbuku.core.DaftarBukuComponent.class)
	public DaftarBuku daftarbukuimpl;
	protected String objectName = StatistikComponent.class.getName();

	public StatistikComponent() {

	} 

	public StatistikComponent(
        DaftarBukuImpl daftarbukuimpl
    ) {
        this.daftarbukuimpl = daftarbukuimpl;
    }

	public abstract DaftarBukuImpl getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(DaftarBukuImpl daftarbukuimpl);
	
 
	public abstract int hitungTotalBuku();

	@Override
    public String toString() {
        return "{" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
	
}
