package it.yellow.infoprovider.client;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.apache.axis2.AxisFault;

import com.seatwave.api.v2.DiscoveryAPIStub.ArrayOfEvent;
import com.seatwave.api.v2.DiscoveryAPIStub.Event;
import com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch;
import com.seatwave.api.v2.DiscoveryAPIStub.EventsSearchResponse;

public class TestSeatwaveService {

	public void test() throws RemoteException {
		com.seatwave.api.v2.DiscoveryAPIStub stub =
				new com.seatwave.api.v2.DiscoveryAPIStub();
		EventsSearch request = new EventsSearch();
		request.setApiKey("ef677ed4c8c740c2b3710287bf4c8b07");
		request.setSiteId(5);
		request.setWhat("Cranberries");
		request.setWhere("Milano");
		
		String dateFrom = "2012-03-01";
		String[] dateFromSplit = dateFrom.split("-");
		String dateTo = "2013-03-01";
		String[] dateToSplit = dateTo.split("-");
		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.set(Integer.parseInt(dateFromSplit[0]), Integer.parseInt(dateFromSplit[1]), Integer.parseInt(dateFromSplit[2]));
		calTo.set(Integer.parseInt(dateToSplit[0]), Integer.parseInt(dateToSplit[1]), Integer.parseInt(dateToSplit[2]));
		
		request.setWhenFrom(calFrom);
		request.setWhenTo(calTo);
		request.setEventsWithoutTix(true);
		
		EventsSearchResponse response = stub.eventsSearch(request);
		if(response.getEventsSearchResult().getStatus().getCode()==0){
			Event[] eventList = response.getEventsSearchResult().getEvents().getEvent();
			if(eventList!=null && eventList.length>0){
				for(Event e : eventList){
					System.out.println("ID: "+e.getId());
					System.out.println("Data: "+e.getDate().getTime());
					System.out.println("Gruppo: "+e.getEventGroupName());
					System.out.println("Luogo: "+e.getVenueName());
					System.out.println("Città: "+e.getTown());
					System.out.println("Biglietti rimasti: "+e.getTicketCount());
					System.out.println("Prezzo minimo: "+e.getMinPrice());
				}
			}			
		}
		
		//		com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch eventsSearch208 = 
//				(com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch) getTestObject(com.seatwave.api.v2.DiscoveryAPIStub.EventsSearch.class);

	}
	
	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		TestSeatwaveService sw = new TestSeatwaveService();
		sw.test();
	}

}
