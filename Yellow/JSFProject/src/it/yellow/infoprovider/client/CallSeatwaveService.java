package it.yellow.infoprovider.client;

import java.rmi.RemoteException;
import java.util.Calendar;

import com.seatwave.api.v2.DiscoveryAPIStub.Event;
import com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch;
import com.seatwave.api.v2.DiscoveryAPIStub.EventsSearchResponse;

public class CallSeatwaveService {

	public Event[] call(String what, String where, String whenFrom, String whenTo, Boolean tix) throws RemoteException {
		com.seatwave.api.v2.DiscoveryAPIStub stub =
				new com.seatwave.api.v2.DiscoveryAPIStub();
		EventsSearch request = new EventsSearch();
		request.setApiKey("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		request.setSiteId(5);
		if(what!=null && !what.equals("")) request.setWhat(what);
		request.setWhere(where);
		
		String dateFrom = whenFrom;
		String[] dateFromSplit = dateFrom.split("-");
		String dateTo = whenTo;
		String[] dateToSplit = dateTo.split("-");
		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.set(Integer.parseInt(dateFromSplit[0]), Integer.parseInt(dateFromSplit[1])-1, Integer.parseInt(dateFromSplit[2]));
		calTo.set(Integer.parseInt(dateToSplit[0]), Integer.parseInt(dateToSplit[1])-1, Integer.parseInt(dateToSplit[2]));
		
		request.setWhenFrom(calFrom);
		request.setWhenTo(calTo);
		request.setEventsWithoutTix(tix);
		
		EventsSearchResponse response = stub.eventsSearch(request);
		if(response.getEventsSearchResult().getStatus().getCode()==0){
			Event[] eventList = response.getEventsSearchResult().getEvents().getEvent();
			if(eventList!=null && eventList.length>0){
//				for(Event e : eventList){
//					System.out.println("ID: "+e.getId());
//					System.out.println("Data: "+e.getDate().getTime());
//					System.out.println("Gruppo: "+e.getEventGroupName());
//					System.out.println("Luogo: "+e.getVenueName());
//					System.out.println("Città: "+e.getTown());
//					System.out.println("Biglietti rimasti: "+e.getTicketCount());
//					System.out.println("Prezzo minimo: "+e.getMinPrice());
//				}
				return eventList;
			}			
		}
		
		//		com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch eventsSearch208 = 
//				(com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch) getTestObject(com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch.class);

		return new Event[0];
	}
	
}
