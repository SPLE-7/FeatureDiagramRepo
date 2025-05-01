package LibraryManagementSystem.recommendation.core;

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


@Entity(name="recommendation_impl")
@Table(name="recommendation_impl")
public class RecommendationImpl extends RecommendationComponent {

	public RecommendationImpl(BukuImpl daftarbukuimpl, AkunImpl akunimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
		this.akunimpl = akunimpl;
	}

	public RecommendationImpl(BukuImpl daftarbukuimpl, AkunImpl akunimpl) {
		this. =  .randomUUID();;
		this.daftarbukuimpl = daftarbukuimpl;
		this.akunimpl = akunimpl;
	}

	public RecommendationImpl() { }


	public void getRecommendation() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> recommendationMap = new HashMap<String,Object>();
		recommendationMap.put("daftarbukuimpl",getDaftarbukuimpl());
		recommendationMap.put("akunimpl",getAkunimpl());

        return recommendationMap;
    }

}
