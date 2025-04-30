package LibraryManagementSystem.akun.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AkunDecorator extends AkunComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AkunComponent record;

	public AkunDecorator () {
		super();
		this.record = record;
		this.idAkun =  idAkun.randomUUID();
		
	public AkunDecorator (AkunComponent record) {
		this.idAkun =  idAkun.randomUUID();
		this.record = record;
	}

	public AkunDecorator (UUID idAkun, AkunComponent record) {
		this.idAkun =  idAkun;
		this.record = record;
	}
	
	public AkunDecorator (AkunComponent record, String objectName) {
		this.idAkun =  idAkun.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public AkunDecorator() { }

	public UUID getIdAkun() {
		return record.getIdAkun();
	}
	public void setIdAkun(UUID idAkun) {
		record.setIdAkun(idAkun);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
