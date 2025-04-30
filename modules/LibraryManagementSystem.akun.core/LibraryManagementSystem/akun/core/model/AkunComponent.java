package LibraryManagementSystem.akun.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="akun_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AkunComponent implements Akun{
	@Id
	protected UUID idAkun; 
	protected String nama;
	protected String objectName = AkunComponent.class.getName();

	public AkunComponent() {

	} 

	public AkunComponent(
        UUID idAkun, String nama
    ) {
        this.idAkun = idAkun;
        this.nama = nama;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idAkun='" + getIdAkun() + "'" +
            " nama='" + getNama() + "'" +
            "}";
    }
	
}
