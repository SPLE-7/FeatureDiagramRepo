package LibraryManagementSystem.recommendation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class RecommendationDecorator extends RecommendationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected RecommendationComponent record;

	public RecommendationDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public RecommendationDecorator (RecommendationComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public RecommendationDecorator (, RecommendationComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public RecommendationDecorator (RecommendationComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public RecommendationDecorator() { }


	public void getRecommendation() {
		return record.getRecommendation();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
