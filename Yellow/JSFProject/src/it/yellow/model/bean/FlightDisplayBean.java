package it.yellow.model.bean;

import java.util.List;

import com.cleartrip.air.PricingSummary;
import com.cleartrip.air.Segment;

public class FlightDisplayBean {

	private Boolean international;
	private PricingSummary pricing;
	private PricingSummary pricingOnward;
	private PricingSummary pricingReturn;
	private List<Segment> onwardSegments;//saranno già solo i primi 5 di andata e ritorno
	private List<Segment> returnSegments;
	public Boolean getInternational() {
		return international;
	}
	public void setInternational(Boolean international) {
		this.international = international;
	}
	public PricingSummary getPricing() {
		return pricing;
	}
	public void setPricing(PricingSummary pricing) {
		this.pricing = pricing;
	}
	public List<Segment> getOnwardSegments() {
		return onwardSegments;
	}
	public void setOnwardSegments(List<Segment> onwardSegments) {
		this.onwardSegments = onwardSegments;
	}
	public List<Segment> getReturnSegments() {
		return returnSegments;
	}
	public void setReturnSegments(List<Segment> returnSegments) {
		this.returnSegments = returnSegments;
	}
	public PricingSummary getPricingOnward() {
		return pricingOnward;
	}
	public void setPricingOnward(PricingSummary pricingOnward) {
		this.pricingOnward = pricingOnward;
	}
	public PricingSummary getPricingReturn() {
		return pricingReturn;
	}
	public void setPricingReturn(PricingSummary pricingReturn) {
		this.pricingReturn = pricingReturn;
	}
	


}
