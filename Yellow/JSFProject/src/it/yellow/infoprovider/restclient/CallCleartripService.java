package it.yellow.infoprovider.restclient;

import it.yellow.model.bean.FlightDisplayBean;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.xml.sax.SAXParseException;

import com.cleartrip.air.AirSearchResult;
import com.cleartrip.air.OnwardSolutions;
import com.cleartrip.air.ReturnSolutions;
import com.cleartrip.air.Solution;
import com.cleartrip.air.Solutions;

public class CallCleartripService {

	public List<FlightDisplayBean> call(String from, String to, String departureDate, String returnDate, String numAdults, String cabinType, Double cambio, int limitResults) throws SAXParseException, Exception{
		String url = "http://api.staging.cleartrip.com/air/1.0/search";
		//ricordarsi l'uri escape
//		String paramString = "from=FCO" +
//				"&to=MXP" +
//				"&depart-date=2012-07-04" +
//				"&return-date=2012-07-09" +
//				"&adults=3" +
//				"&cabin-type=Economy";
		WebClient client=WebClient.create(url);
        client.header("X-CT-API-KEY", "XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        client.accept("application/xml");
        client.query("from", from);//IATA CODES da tenere nel db!
        client.query("to", to);
        client.query("depart-date", departureDate);
        client.query("return-date", returnDate);
        client.query("adults", numAdults);
//        client.query("cabin-type", cabinType);
        System.out.println("Dati callCleartrip: "+from+"_"+to+"_"+departureDate+"_"+returnDate+"_"+numAdults);

        AirSearchResult res = client.get(AirSearchResult.class);
        
        List<FlightDisplayBean> solutions = new ArrayList<FlightDisplayBean>();
        
        if(res.getSolutionsOrOnwardSolutionsOrReturnSolutions()!=null){
        	for(Object o: res.getSolutionsOrOnwardSolutionsOrReturnSolutions()){
        		if(o instanceof Solutions){
        			int index=0;
        			for(Solution s:((Solutions)o).getSolution()){
        				if(index>limitResults) break;
        				FlightDisplayBean bean = new FlightDisplayBean();
            			bean.setInternational(true);
            			bean.setPricing(s.getPricingSummary());
            			bean.setOnwardSegments(s.getFlights().getFlight().get(0).getSegments().getSegment());
            			if(s.getFlights().getFlight().size()>1){
            				//volo  di ritorno
            				bean.setReturnSegments(s.getFlights().getFlight().get(1).getSegments().getSegment());
            			}
            			//converto al tasso di cambio
            			bean.getPricing().setBaseFare(bean.getPricing().getBaseFare()*cambio.floatValue());
//            			bean.getPricing().setFees(bean.getPricing().getFees()*cambio.floatValue());
            			bean.getPricing().setTaxes(bean.getPricing().getTaxes()*cambio.floatValue());
            			bean.getPricing().setTotalFare(bean.getPricing().getTotalFare()*cambio.floatValue());
            			solutions.add(bean);
            			index++;
        			}
        		}
        		else if(o instanceof OnwardSolutions){
        			int index=0;
        			OnwardSolutions os = (OnwardSolutions)o;
        			for(Solution s: os.getSolution()){
        				if(index>limitResults) break;
        				FlightDisplayBean bean = new FlightDisplayBean();
            			bean.setInternational(true);
            			bean.setPricingOnward(s.getPricingSummary());
            			bean.setOnwardSegments(s.getFlights().getFlight().get(0).getSegments().getSegment());
            			//converto al tasso di cambio
            			bean.getPricingOnward().setBaseFare(bean.getPricingOnward().getBaseFare()*cambio.floatValue());
//            			bean.getPricingOnward().setFees(bean.getPricingOnward().getFees()*cambio.floatValue());
            			bean.getPricingOnward().setTaxes(bean.getPricingOnward().getTaxes()*cambio.floatValue());
            			bean.getPricingOnward().setTotalFare(bean.getPricingOnward().getTotalFare()*cambio.floatValue());
            			
            			solutions.add(bean);
            			index++;
        			}
        		}
        		else if(o instanceof ReturnSolutions){
        			int index=0;
        			ReturnSolutions rs = (ReturnSolutions)o;
        			for(Solution s: rs.getSolution()){
        				if(index>limitResults) break;
        				solutions.get(index).setPricingReturn(s.getPricingSummary());
        				solutions.get(index).setReturnSegments(s.getFlights().getFlight().get(0).getSegments().getSegment());
        				//converto al tasso di cambio
        				solutions.get(index).getPricingReturn().setBaseFare(solutions.get(index).getPricingReturn().getBaseFare()*cambio.floatValue());
//            			bean.getPricingReturn().setFees(bean.getPricingReturn().getFees()*cambio.floatValue());
        				solutions.get(index).getPricingReturn().setTaxes(solutions.get(index).getPricingReturn().getTaxes()*cambio.floatValue());
        				solutions.get(index).getPricingReturn().setTotalFare(solutions.get(index).getPricingReturn().getTotalFare()*cambio.floatValue());
            			
        				index++;
        			}
        		}
        		else{
        			//nothing
        		} 
        	}
        }
        return solutions;
	}
	
	public static void main(String[] args) throws Exception{
		CallCleartripService srv = new CallCleartripService();
		List<FlightDisplayBean> ss = srv.call("FCO", "MXP", "2012-07-12", "2012-07-19", "3", "Economy", new Double(1), 4);
		System.out.println(ss.size());
	}
	
//	How to handle rounding of the prices in case of flights?
//			In case of multiple flight booking, add prices of all the flights and then do the rounding (to nearest Integer).
//	What are Stops Details?
//			If a flight has a stop in a segemnt then in the flight results XML under segments there will be a tag called stops details. In case of Domastic flights for Air India, Indian airlines, Jet Airways and Kingfisher we do not get the stop details.
//	What is the difference between international and domestic flight results XMLs?
//			In case of domestic search result, onward flights are contained in the tag <onward-solutions> and return flights are contained in the tag <return-solutions>. However, in case of international search result both onward and return flights are contained in the tag <solutions>
//	After how long the search flights are timed out for booking?
//			In case of Domestic there is no time out for making create itinerary request. In case of international, one can only do the create itinerary call before 2 hours from the time of search.
//	Where to find the airport, airline dump?
//			You can get the list of all airports, cities and countries using the web service available at:
//			http://www.cleartrip.com/air/1.0/airports
//			And for a particular airport you can specify airport code as follows:
//			http://www.cleartrip.com/air/1.0/airports/<airport-code>
//			e.g. http://www.cleartrip.com/air/1.0/airports/LHR
//
//			Similarly, for airlines the URLs are:
//			http://www.cleartrip.com/air/1.0/airlines
//			http://www.cleartrip.com/air/1.0/airlines/<airline-code>
//			e.g. http://www.cleartrip.com/air/1.0/airlines/9W
	
}
