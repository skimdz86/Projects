package it.yellow.fe.threads;

import it.yellow.model.bean.FlightDisplayBean;
import it.yellow.model.bean.FlightDisplayBeanList;

import java.util.HashMap;
import java.util.List;

public class FlightDataContainer {

	public static FlightDataContainer instance = null;
	
	public static FlightDataContainer getInstance(){
		if(instance == null){
			instance = new FlightDataContainer();
		}
		return instance;
	}
	
	private String from, to, departureDate, returnDate, numAdults, cabinType; 
	private Double cambio;
	int limitResults;

	boolean semaphore = true;
	
	private HashMap<String, FlightDisplayBeanList> allFlights = new HashMap<String, FlightDisplayBeanList>();

	public synchronized boolean lockSemaphore(){
		if(semaphore) {
			semaphore = false;//se era libero lock
			return true;
		}
		return false;
	}
	
	public void unlockSemaphore(){
		semaphore = true;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getNumAdults() {
		return numAdults;
	}
	public void setNumAdults(String numAdults) {
		this.numAdults = numAdults;
	}
	public String getCabinType() {
		return cabinType;
	}
	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}
	public Double getCambio() {
		return cambio;
	}
	public void setCambio(Double cambio) {
		this.cambio = cambio;
	}
	public int getLimitResults() {
		return limitResults;
	}
	public void setLimitResults(int limitResults) {
		this.limitResults = limitResults;
	}
	
	public HashMap<String, FlightDisplayBeanList> getAllFlights() {
		return allFlights;
	}

	public void setAllFlights(HashMap<String, FlightDisplayBeanList> allFlights) {
		this.allFlights = allFlights;
	}

	public synchronized void addFlight(String code, List<FlightDisplayBean> flights) {
		FlightDisplayBeanList list = new FlightDisplayBeanList();
		list.setFlightList(flights);
		this.allFlights.put(code, list);
	}
}
