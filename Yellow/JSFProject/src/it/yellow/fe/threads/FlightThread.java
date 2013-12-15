package it.yellow.fe.threads;

import java.util.ArrayList;
import java.util.List;

import it.yellow.infoprovider.restclient.CallCleartripService;
import it.yellow.model.bean.FlightDisplayBean;

import org.xml.sax.SAXParseException;

public class FlightThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		FlightDataContainer fd = FlightDataContainer.getInstance();
		CallCleartripService service = new CallCleartripService();
		System.out.println("THREAD: "+fd.getFrom());
		try{
			String from = fd.getFrom();
			fd.unlockSemaphore();//libero il semaforo
			List<FlightDisplayBean> flights = service.call(from, fd.getTo(), fd.getDepartureDate(), fd.getReturnDate(), fd.getNumAdults(), fd.getCabinType(), fd.getCambio(), fd.getLimitResults());
			if(flights!=null) fd.addFlight(from, flights);
			else fd.addFlight(from, new ArrayList<FlightDisplayBean>());
		}catch(SAXParseException e){
			e.printStackTrace();
			//non trovati voli
			
		} catch (Exception e) {
			e.printStackTrace();
			//non trovati voli
		}

		
	}

	
}
