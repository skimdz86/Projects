package it.yellow.fe.controller;

import it.yellow.fe.threads.FlightDataContainer;
import it.yellow.fe.threads.FlightThread;
import it.yellow.infoprovider.client.CallCurrencyService;
import it.yellow.infoprovider.client.CallExpediaService;
import it.yellow.infoprovider.client.CallSeatwaveService;
import it.yellow.infoprovider.restclient.CallCleartripService;
import it.yellow.model.bean.EventDisplayBean;
import it.yellow.model.bean.FlightDisplayBean;
import it.yellow.model.bean.FlightDisplayBeanList;
import it.yellow.model.bean.HotelDisplayBean;
import it.yellow.model.bean.Room;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.DateSelectEvent;
import org.xml.sax.SAXParseException;

import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelList;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelRoomAvailabilityResponse;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelRoomResponse;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelSummary;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.RoomRateDetails;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.ValueAdd;
import com.seatwave.api.v2.DiscoveryAPIStub.Event;

@ManagedBean(name="testProviderController")
@RequestScoped
//@SessionScoped
public class TestProviderController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/testPage.jsf";
	
	protected String city;
	protected String countryCode;
	protected Date arrivalDate;
	protected Date departureDate;
	protected String numAdults;
	
	protected String what;
	protected String where;
	protected Date whenFrom;
	protected Date whenTo;
	protected Boolean eventWithoutTix;
	
	protected String from;
	protected String from2;
	protected String from3;
	protected String to;
	protected Date flightDepDate;
	protected Date flightReturnDate;
	protected String numberPeople;
	protected String numberPeople2;
	protected String numberPeople3;
	protected String cabinType;
	
	protected String output;
	protected String outputEvent;
	
	private List<EventDisplayBean> events = new ArrayList<EventDisplayBean>();
	private List<HotelDisplayBean> hotels = new ArrayList<HotelDisplayBean>();
	private List<FlightDisplayBean> flights = new ArrayList<FlightDisplayBean>();
	private List<FlightDisplayBean> flights2 = new ArrayList<FlightDisplayBean>();
	private List<FlightDisplayBean> flights3 = new ArrayList<FlightDisplayBean>();
	
	private HashMap<String, String> airportMap = AirCodeUtils.codeToAirport;
	
	private Boolean firstPageVisit = true;
	
	SimpleDateFormat sdfAmericanShort = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat sdfAmerican = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat sdfDashReverse = new SimpleDateFormat("yyyy-MM-dd");
	
	protected String errorMessage;
	protected Date currDate = new Date();
	protected Date dateLimit = new Date();
	
	@PostConstruct
	public void init(){
		hotels.clear();
		events.clear();
		flights.clear();
		flights2.clear();
		flights3.clear();
		System.out.println("FISRT VISIT? "+firstPageVisit);
		//--e poi aggiornare un altra data che indica dinamicamente la prima delle due e usarla come min date della seconda, piu un controllo server
		System.out.println("Date: "+currDate.toString());
		System.out.println("Date limit: "+dateLimit.toString());
	}
	
	public void doSubmitHotel(){
		System.out.println("In submit hotel");
		hotels.clear();
		CallExpediaService service = new CallExpediaService();
		HotelList hotelList = null;
		String countryCodeTwoDigit = CountryUtils.coutryCodes.get(countryCode);
		System.out.println("CountryCode: "+countryCodeTwoDigit);
		try {
			//date in formato MM/dd/yyyy
			hotelList = service.callList(city, countryCodeTwoDigit, sdfAmerican.format(departureDate), sdfAmerican.format(arrivalDate), numAdults);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(hotelList!=null){
//fare un oggetto per l'output: il popolamento degli oggetti per il display andrà fatto nella logica poi, non qui
//o forse usare già i bean jaxb, ma se cambiano la specifica poi siamo fregati, forse è meglio un mapping nostro
			int limit = 0;
			for(HotelSummary h: hotelList.getHotelSummary()){
				if(limit>5) break;
				HotelDisplayBean hotel = new HotelDisplayBean();
				hotel.setHotelId(""+h.getHotelId());
				hotel.setName(h.getName());
				hotel.setAddress(h.getAddress1());
				hotel.setCity(h.getCity());
				hotel.setCountry(h.getCountryCode());
				hotel.setPostalCode(h.getPostalCode());
				hotel.setHotelRating(""+h.getHotelRating());
				hotel.setLocationDescription(h.getLocationDescription());
				hotel.setShortDescription(h.getShortDescription().replaceAll("&lt;p&gt;&lt;b&gt;", "").replaceAll("&lt;/b&gt; &lt;br /&gt;", ""));
				hotel.setImageUrl("http://images.travelnow.com"+h.getThumbNailUrl());
				hotel.setUrl(h.getDeepLink());
				List<Room> rooms = new ArrayList<Room>();
				for(RoomRateDetails r : h.getRoomRateDetailsList().getRoomRateDetails()){
					Room room = new Room();
					room.setRoomDescription(r.getRoomDescription());
					room.setMaxOccupants(""+r.getMaxRoomOccupancy());
					room.setTotalCharge(new BigDecimal(r.getRateInfo().getChargeableRateInfo().getTotal()));
					List<String> valueAdds = new ArrayList<String>();
					for(ValueAdd v: r.getValueAdds().getValueAdd()){
						valueAdds.add(v.getDescription());
					}
					room.setValueAdds(valueAdds);
					
					rooms.add(room);
				}
						
				hotels.add(hotel);
				limit++;
			}
		}
		System.out.println(hotels);
		firstPageVisit = false;
	}
	
	public void doSubmitEvent(){
		System.out.println("In submit event");
		events.clear();
		CallSeatwaveService service = new CallSeatwaveService();
		Event[] eventList = null;
		try {
			//formato date: yyyy-MM-dd
			eventList = service.call(what, where, sdfDashReverse.format(whenFrom), sdfDashReverse.format(whenTo), eventWithoutTix);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(eventList!=null){
//fare un oggetto per l'output: il popolamento degli oggetti per il display andrà fatto nella logica poi, non qui
//o forse usare già i bean jaxb, ma se cambiano la specifica poi siamo fregati, forse è meglio un mapping nostro
			int limit=0;
			for(Event e: eventList){
				if(limit>5) break;
				EventDisplayBean ev = new EventDisplayBean();
				ev.setEventId(""+e.getId());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				ev.setDate(sdf.format(e.getDate().getTime()));
				SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
				ev.setTime(sdf2.format(e.getDate().getTime()));
				ev.setWhat(e.getEventGroupName());
				ev.setWhere(e.getVenueName());
				ev.setTown(e.getTown());
				ev.setCountry(e.getCountry());
				ev.setTicketCount(""+e.getTicketCount());
				ev.setMinPrice(e.getMinPrice().toString());
				ev.setCurrency(e.getCurrency());
				ev.setUrl(e.getSwURL());
				ev.setImageUrl(e.getEventGroupImageURL());
				
				events.add(ev);
				limit++;
			}
		}
		firstPageVisit = false;
		
	}

	
	public void doSubmitFlight(){//per ora contemplati solo voli andata e ritorno
		System.out.println("In submit flight");
		flights.clear();
		//get cambio valuta
		CallCurrencyService currencySrv = new CallCurrencyService();
		Double cambio = new Double(1);
		try {
			cambio = currencySrv.call();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		CallCleartripService service = new CallCleartripService();
		//codifico i parametri:
		System.out.println("DECODED: "+from);
		from = AirCodeUtils.airportToCode.get(from);
		to = AirCodeUtils.airportToCode.get(to);
		System.out.println("CODED: "+from);
		try{
			//formato date yyyy-MM-dd
			flights = service.call(from, to, sdfDashReverse.format(flightDepDate), sdfDashReverse.format(flightReturnDate), numberPeople, cabinType, cambio, 4);
		}catch(SAXParseException e){
			e.printStackTrace();
			//non trovati voli
			System.out.println("MESS: "+e.getMessage());
			if(e.getMessage()!=null && e.getMessage().contains("Content is not allowed in prolog")) setErrorMessage("Test environment temporarily not available");
			
		}catch(Exception e){
			e.printStackTrace();
			//non trovati voli
			System.out.println("MESSAGE: "+e.getMessage());
			if(e.getMessage()!=null && e.getMessage().contains("Content is not allowed in prolog")) setErrorMessage("Test environment temporarily not available");
		}
		firstPageVisit = false;

	}
	
	
	
	public void doSubmitAllInOne(){
		System.out.println("In submit all-in-one");
		
		try{
			boolean proceed = true;//se lo valuto, posso stoppare la ricerca successiva in caso non ci sia un volo o un hotel per il periodo
			flights.clear();
			flights2.clear();
			flights3.clear();
			hotels.clear();
			events.clear();
			//get cambio valuta
			CallCurrencyService currencySrv = new CallCurrencyService();
			Double cambio = new Double(1);
			try {
				cambio = currencySrv.call();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			CallCleartripService service = new CallCleartripService();
			//codifico i parametri:
			String fromCode = "", fromCode2 = "", fromCode3 = "", toCode = "";
			System.out.println("DECODED: "+from);
			fromCode = AirCodeUtils.airportToCode.get(from);
			if(from2!=null && !from2.equals("")) fromCode2 = AirCodeUtils.airportToCode.get(from2);
			if(from3!=null && !from3.equals("")) fromCode3 = AirCodeUtils.airportToCode.get(from3);
			toCode = AirCodeUtils.airportToCode.get(to);
			System.out.println("CODED: "+fromCode);
//			try{
//				flights = service.call(fromCode, toCode, flightDepDate, flightReturnDate, numberPeople, cabinType, cambio, 3);
//			}catch(SAXParseException e){
//				e.printStackTrace();
//				//non trovati voli
//				proceed = false;
//			}
			
			//gestione con thread, pessima
			FlightDataContainer fdt = FlightDataContainer.getInstance();
			fdt.setTo(toCode);
			fdt.setDepartureDate(sdfDashReverse.format(flightDepDate));
			fdt.setReturnDate(sdfDashReverse.format(flightReturnDate));
			fdt.setCabinType(cabinType);
			fdt.setCambio(cambio);
			fdt.setLimitResults(3);
			FlightThread ft1 = new FlightThread();
			FlightThread ft2 = new FlightThread();
			FlightThread ft3 = new FlightThread();
			Thread t1 = new Thread(ft1);
			Thread t2 = new Thread(ft2);
			Thread t3 = new Thread(ft3);
			fdt.lockSemaphore();//qui è per forza libero
			fdt.setFrom(fromCode);//FIXME: controllare che non si sovrascrivano la variabie mentre la usano: SEMAFORO?
			fdt.setNumAdults(numberPeople);
			t1.start();
			if(from2!=null && !from2.equals("")){
				while(!fdt.lockSemaphore()){
					//aspetto
				}
				fdt.setFrom(fromCode2);
				fdt.setNumAdults(numberPeople2);
				t2.start();
			} 
			if(from3!=null && !from3.equals("")){
				while(!fdt.lockSemaphore()){
					//aspetto
				}
				fdt.setFrom(fromCode3);
				fdt.setNumAdults(numberPeople3);
				t3.start();
			}
			
			try{
				t1.join();
				if(from2!=null && !from2.equals("")) t2.join();
				if(from3!=null && !from3.equals("")) t3.join();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			HashMap<String, FlightDisplayBeanList> resList = fdt.getAllFlights();
			if(resList.get(fromCode)!=null) flights = resList.get(fromCode).getFlightList();
			if(from2!=null  && !from2.equals("") && resList.get(fromCode2)!=null) flights2 = resList.get(fromCode2).getFlightList();
			if(from3!=null && !from3.equals("") && resList.get(fromCode3)!=null) flights3 = resList.get(fromCode3).getFlightList();
			 
			//hotels
			String destination = to.substring(0, to.indexOf("[")-1);
			if(destination.indexOf("-")!=-1) destination = destination.substring(0, destination.indexOf("-")-1);
			System.out.println("Hotel destination: "+destination);
			String hotelArrivalDate = "", hotelDepartureDate = "";
			/*Gestione inutile, ora uso simpledateformat
			String[] tmpFlightDepDate, tmpFlightRetDate;
			tmpFlightDepDate = flightDepDate.split("-");
			tmpFlightRetDate = flightReturnDate.split("-");
			hotelArrivalDate = tmpFlightDepDate[1]+"/"+tmpFlightDepDate[2]+"/"+tmpFlightDepDate[0];
			hotelDepartureDate = tmpFlightRetDate[1]+"/"+tmpFlightRetDate[2]+"/"+tmpFlightRetDate[0];
			*/
			hotelArrivalDate = sdfAmerican.format(flightDepDate);
			hotelDepartureDate = sdfAmerican.format(flightReturnDate);
			
			Integer totalPeople = Integer.parseInt(numberPeople)+(from2!=null && !from2.equals("")?Integer.parseInt(numberPeople2):0)+(from3!=null && !from3.equals("")?Integer.parseInt(numberPeople3):0);
			System.out.println("Total people toString: "+totalPeople.toString());
			CallExpediaService hotelService = new CallExpediaService();
			HotelList hotelList = null;
			try {
				hotelList = hotelService.callGeneral(destination, hotelDepartureDate, hotelArrivalDate, totalPeople);//departure e arival date invertite risp al volo: la departure del volo è l'andata, la departure dall'hotel è il ritorno
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(hotelList!=null){
	//fare un oggetto per l'output: il popolamento degli oggetti per il display andrà fatto nella logica poi, non qui
	//o forse usare già i bean jaxb, ma se cambiano la specifica poi siamo fregati, forse è meglio un mapping nostro
				int limit = 0;
				for(HotelSummary h: hotelList.getHotelSummary()){
					if(limit>3) break;
					HotelDisplayBean hotel = new HotelDisplayBean();
					hotel.setHotelId(""+h.getHotelId());
					hotel.setName(h.getName());
					hotel.setAddress(h.getAddress1());
					hotel.setCity(h.getCity());
					hotel.setCountry(h.getCountryCode());
					hotel.setPostalCode(h.getPostalCode());
					hotel.setHotelRating(""+h.getHotelRating());
					hotel.setLocationDescription(h.getLocationDescription());
					hotel.setShortDescription(h.getShortDescription().replaceAll("&lt;p&gt;&lt;b&gt;", "").replaceAll("&lt;/b&gt; &lt;br /&gt;", ""));
					hotel.setImageUrl("http://images.travelnow.com"+h.getThumbNailUrl());
					hotel.setUrl(h.getDeepLink());
					
					//MODIFICA: chiamo anche la getAvailability per ottenere più stanze
					HashMap<Integer, Integer> roomAssoc = new HashMap<Integer, Integer>();
					if(totalPeople>4){
			        	   int numRoom = totalPeople/4+(totalPeople%4==0?0:1);
			        	   for(int i=0;i<numRoom;i++){
			        		   int numPerRoom = i==numRoom-1?totalPeople%4:4;
			        		   if(totalPeople%4==1 && i==numRoom-2) numPerRoom-=1;//tolgo uno dalla penultima stanza
			        		   if(totalPeople%4==1 && i==numRoom-1) numPerRoom+=1;//e lo metto nell'ultima, così non lascio nessuno da solo
			                   roomAssoc.put(i, numPerRoom);
			        	   }
			        	   
			        }
					else{
						roomAssoc.put(0, totalPeople);
			        }
					HotelRoomAvailabilityResponse roomHotelList = null;
					try{
						roomHotelList = hotelService.callGetAvailability(h.getHotelId(), hotelDepartureDate, hotelArrivalDate, roomAssoc);
					}catch(RemoteException e){
						e.printStackTrace();
					}
					
					List<Room> rooms = new ArrayList<Room>();
					
					if(roomHotelList!=null){
						for(HotelRoomResponse r: roomHotelList.getHotelRoomResponse()){
							Room room = new Room();
							room.setRoomDescription(r.getRoomTypeDescription());
							room.setMaxOccupants(""+r.getRateOccupancyPerRoom());
							room.setTotalCharge(new BigDecimal(r.getRateInfo().getChargeableRateInfo().getTotal()));
							room.setRemainingRooms(""+r.getCurrentAllotment());
							room.setUrl(r.getDeepLink());
							List<String> valueAdds = new ArrayList<String>();
							if(r.getValueAdds()!=null){
								for(ValueAdd v: r.getValueAdds().getValueAdd()){
									valueAdds.add(v.getDescription());
								}
							}
							room.setValueAdds(valueAdds);
							
							rooms.add(room);
						}
					}
					else{
						for(RoomRateDetails r : h.getRoomRateDetailsList().getRoomRateDetails()){
							Room room = new Room();
							room.setRoomDescription(r.getRoomDescription());
							room.setMaxOccupants(""+r.getMaxRoomOccupancy());
							room.setTotalCharge(new BigDecimal(r.getRateInfo().getChargeableRateInfo().getTotal()));
							room.setRemainingRooms(""+r.getCurrentAllotment());
//							room.setUrl("");
							List<String> valueAdds = new ArrayList<String>();
							if(r.getValueAdds()!=null){
								for(ValueAdd v: r.getValueAdds().getValueAdd()){
									valueAdds.add(v.getDescription());
								}
							}
							room.setValueAdds(valueAdds);
							
							rooms.add(room);
						}
					}
					
					hotel.setRooms(rooms);		
					hotels.add(hotel);
					limit++;
				}
			}
			
			//events
			System.out.println("Finding events.....");
			CallSeatwaveService eventService = new CallSeatwaveService();
			Event[] eventList = null;
			try {
				eventList = eventService.call(what, destination, sdfDashReverse.format(flightDepDate), sdfDashReverse.format(flightReturnDate), eventWithoutTix);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(eventList!=null){
	//fare un oggetto per l'output: il popolamento degli oggetti per il display andrà fatto nella logica poi, non qui
	//o forse usare già i bean jaxb, ma se cambiano la specifica poi siamo fregati, forse è meglio un mapping nostro
				int limit=0;
				for(Event e: eventList){
					if(limit>3) break;
					EventDisplayBean ev = new EventDisplayBean();
					ev.setEventId(""+e.getId());
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					ev.setDate(sdf.format(e.getDate().getTime()));
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
					ev.setTime(sdf2.format(e.getDate().getTime()));
					ev.setWhat(e.getEventGroupName());
					ev.setWhere(e.getVenueName());
					ev.setTown(e.getTown());
					ev.setCountry(e.getCountry());
					ev.setTicketCount(""+e.getTicketCount());
					ev.setMinPrice(e.getMinPrice().toString());
					ev.setCurrency(e.getCurrency());
					ev.setUrl(e.getSwURL());
					ev.setImageUrl(e.getEventGroupImageURL());
					
					events.add(ev);
					limit++;
				}
			}
			
			firstPageVisit = false;
			System.out.println("FIRST_PAGE_END visit?: "+firstPageVisit);
		}catch(Exception e){
			System.out.println("GENERIC ERROR: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public List<String> completeAirport(String query){
//		System.out.println("FILTER");
		List<String> results = new ArrayList<String>();
		String fromFilter = query;
		for(String s: AirCodeUtils.airportToCode.keySet()){
//			System.out.println(s.toLowerCase());
//			System.out.println(fromFilter.toLowerCase());
			if(s.toLowerCase().contains(fromFilter.toLowerCase())) results.add(s);
		}
		return results;
	}
	
	
	public List<String> completeCountry(String query){
//		System.out.println("FILTER");
		List<String> results = new ArrayList<String>();
		String fromFilter = query;
		for(String s: CountryUtils.coutryCodes.keySet()){
//			System.out.println(s.toLowerCase());
//			System.out.println(fromFilter.toLowerCase());
			if(s.toLowerCase().contains(fromFilter.toLowerCase())) results.add(s);
		}
		return results;
	}
	
	public void limitDates(DateSelectEvent event) {  
        dateLimit = event.getDate();  
    }  
	
	/**METODI ACCESSORI**/
	
	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(String numAdults) {
		this.numAdults = numAdults;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public Date getWhenFrom() {
		return whenFrom;
	}

	public void setWhenFrom(Date whenFrom) {
		this.whenFrom = whenFrom;
	}

	public Date getWhenTo() {
		return whenTo;
	}

	public void setWhenTo(Date whenTo) {
		this.whenTo = whenTo;
	}

	public Boolean getEventWithoutTix() {
		return eventWithoutTix;
	}

	public void setEventWithoutTix(Boolean eventWithoutTix) {
		this.eventWithoutTix = eventWithoutTix;
	}

	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}

	public String getOutputEvent() {
		return outputEvent;
	}

	public void setOutputEvent(String outputEvent) {
		this.outputEvent = outputEvent;
	}

	public List<EventDisplayBean> getEvents() {
		return events;
	}

	public void setEvents(List<EventDisplayBean> events) {
		this.events = events;
	}

	public List<HotelDisplayBean> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDisplayBean> hotels) {
		this.hotels = hotels;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom2() {
		return from2;
	}

	public void setFrom2(String from2) {
		this.from2 = from2;
	}

	public String getFrom3() {
		return from3;
	}

	public void setFrom3(String from3) {
		this.from3 = from3;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getFlightDepDate() {
		return flightDepDate;
	}

	public void setFlightDepDate(Date flightDepDate) {
		this.flightDepDate = flightDepDate;
	}

	public Date getFlightReturnDate() {
		return flightReturnDate;
	}

	public void setFlightReturnDate(Date flightReturnDate) {
		this.flightReturnDate = flightReturnDate;
	}

	public String getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(String numberPeople) {
		this.numberPeople = numberPeople;
	}

	public String getNumberPeople2() {
		return numberPeople2;
	}

	public void setNumberPeople2(String numberPeople2) {
		this.numberPeople2 = numberPeople2;
	}

	public String getNumberPeople3() {
		return numberPeople3;
	}

	public void setNumberPeople3(String numberPeople3) {
		this.numberPeople3 = numberPeople3;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public List<FlightDisplayBean> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDisplayBean> flights) {
		this.flights = flights;
	}

	public List<FlightDisplayBean> getFlights2() {
		return flights2;
	}

	public void setFlights2(List<FlightDisplayBean> flights2) {
		this.flights2 = flights2;
	}

	public List<FlightDisplayBean> getFlights3() {
		return flights3;
	}

	public void setFlights3(List<FlightDisplayBean> flights3) {
		this.flights3 = flights3;
	}

	public HashMap<String, String> getAirportMap() {
		return airportMap;
	}

	public void setAirportMap(HashMap<String, String> airportMap) {
		this.airportMap = airportMap;
	}

	public Boolean getFirstPageVisit() {
		return firstPageVisit;
	}

	public void setFirstPageVisit(Boolean firstPageVisit) {
		this.firstPageVisit = firstPageVisit;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}


	
	
	
}
