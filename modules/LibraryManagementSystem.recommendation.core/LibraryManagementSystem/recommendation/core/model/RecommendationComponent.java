package LibraryManagementSystem.recommendation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="recommendation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RecommendationComponent implements Recommendation{
	@Id
	
	@ManyToOne(targetEntity=LibraryManagementSystem.buku.core.BukuComponent.class)
	public Buku daftarbukuimpl;
	@ManyToOne(targetEntity=LibraryManagementSystem.akun.core.AkunComponent.class)
	public Akun akunimpl;
	protected String objectName = RecommendationComponent.class.getName();

	public RecommendationComponent() {

	} 

	public RecommendationComponent(
        BukuImpl daftarbukuimpl, AkunImpl akunimpl
    ) {
        this.daftarbukuimpl = daftarbukuimpl;
        this.akunimpl = akunimpl;
    }

	public abstract BukuImpl getDaftarbukuimpl();
	public abstract void setDaftarbukuimpl(BukuImpl daftarbukuimpl);
	
	public abstract AkunImpl getAkunimpl();
	public abstract void setAkunimpl(AkunImpl akunimpl);
	
 
	public abstract void getRecommendation();

	@Override
    public String toString() {
        return "{" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            "}";
    }
	
}
