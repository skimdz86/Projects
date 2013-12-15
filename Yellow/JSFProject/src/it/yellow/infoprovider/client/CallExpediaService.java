package it.yellow.infoprovider.client;

import java.rmi.RemoteException;
import java.util.HashMap;

import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetAvailability;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetAvailabilityE;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetAvailabilityResponseE;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetList;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListE;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelList;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelListRequest;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelRoomAvailabilityRequest;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelRoomAvailabilityResponse;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.Room;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.RoomGroup;

public class CallExpediaService {

	public  HotelList callList(String city, String country, String departureDate, String arrivalDate, String numAdults) throws RemoteException{

        com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub stub =
                    new com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub();//the default implementation should point to the right endpoint

//        Options options = new Options();
//        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
       
        //FIX per errore 411
        stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
        //devo popolare la request!!!
        
           GetListE getList0 = new GetListE();
           HotelListRequest req = new HotelListRequest();
           req.setApiKey("cjpkx9y3j6rfyr8s6drz6q4y");
           req.setCid(55505);
           req.setCustomerIpAddress("79.17.154.169");
           req.setCustomerUserAgent("Mozilla/Firefox 5.0");
           req.setCity(city);
           req.setCountryCode(country);
           req.setDepartureDate(departureDate);
           req.setArrivalDate(arrivalDate);
           
           RoomGroup roomGroup = new RoomGroup();
           Room room = new Room();
           room.setNumberOfAdults(Integer.parseInt(numAdults));
           roomGroup.addRoom(room);
           req.setRoomGroup(roomGroup);
           
           GetList param = new GetList();
           param.setHotelListRequest(req);
           
           getList0.setGetList(param);
           
           //call
           com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE getList44=
                                                        (com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE)stub.getList(getList0);
        

           
           System.out.println(getList44.toString());
           
           return getList44.getGetListResponse().getHotelListResponse().getHotelList();

    }
	
	public  HotelRoomAvailabilityResponse callGetAvailability(long hotelId, String departureDate, String arrivalDate, HashMap<Integer, Integer> roomAssociation) throws RemoteException{

        com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub stub =
                    new com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub();//the default implementation should point to the right endpoint
        System.out.println("Call getAvailability: "+hotelId);
//        Options options = new Options();
//        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
       
        //FIX per errore 411
        stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
        //devo popolare la request!!!
        
           GetAvailabilityE getAvailability4 = new GetAvailabilityE();
           HotelRoomAvailabilityRequest req = new HotelRoomAvailabilityRequest();
           req.setApiKey("cjpkx9y3j6rfyr8s6drz6q4y");
           req.setCid(55505);
           req.setCustomerIpAddress("79.17.154.169");
           req.setCustomerUserAgent("Mozilla/Firefox 5.0");
           req.setDepartureDate(departureDate);
           req.setArrivalDate(arrivalDate);
           req.setHotelId(hotelId);
           
           //roomAssociation: key->numero della stanza, 1,2,3...; value= numero persone per la stanza
           
           RoomGroup roomGroup = new RoomGroup();
           
           for(Integer i:roomAssociation.keySet()){
        	   Room room = new Room();
               room.setNumberOfAdults(roomAssociation.get(i));
               roomGroup.addRoom(room);
           }
           req.setRoomGroup(roomGroup);
           
           GetAvailability param = new GetAvailability();
           param.setHotelRoomAvailabilityRequest(req);
           
           getAvailability4.setGetAvailability(param);
           
           //call
            GetAvailabilityResponseE getAval44 = (GetAvailabilityResponseE) stub.getAvailability(getAvailability4);
        

           
           System.out.println(getAval44.toString());
           
           return getAval44.getGetAvailabilityResponse().getHotelRoomAvailabilityResponse();

        }
	
	
	
	public  HotelList callGeneral(String destination, String departureDate, String arrivalDate, Integer numAdults) throws RemoteException{

        com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub stub =
                    new com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub();//the default implementation should point to the right endpoint

//        Options options = new Options();
//        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
       
        //FIX per errore 411
        stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
        //devo popolare la request!!!
        
           GetListE getList0 = new GetListE();
           HotelListRequest req = new HotelListRequest();
           req.setApiKey("cjpkx9y3j6rfyr8s6drz6q4y");
           req.setCid(55505);
           req.setCustomerIpAddress("79.17.154.169");
           req.setCustomerUserAgent("Mozilla/Firefox 5.0");
           req.setDestinationString(destination);
           req.setDepartureDate(departureDate);
           req.setArrivalDate(arrivalDate);
           
           RoomGroup roomGroup = new RoomGroup();
           
           if(numAdults>4){
        	   int numRoom = numAdults/4+(numAdults%4==0?0:1);
        	   for(int i=0;i<numRoom;i++){
        		   Room room = new Room();
        		   int numPerRoom = i==numRoom-1?numAdults%4:4;
        		   if(numAdults%4==1 && i==numRoom-2) numPerRoom-=1;//tolgo uno dalla penultima stanza
        		   if(numAdults%4==1 && i==numRoom-1) numPerRoom+=1;//e lo metto nell'ultima, così non lascio nessuno da solo
                   room.setNumberOfAdults(numPerRoom);
                   roomGroup.addRoom(room);
        	   }
        	   
           }
           else{
        	   Room room = new Room();
               room.setNumberOfAdults(numAdults);
               roomGroup.addRoom(room); 
           }
           
           req.setRoomGroup(roomGroup);
           
           GetList param = new GetList();
           param.setHotelListRequest(req);
           
           getList0.setGetList(param);
           
           //call
           com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE getList44=
                                                        (com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE)stub.getList(getList0);
        

           
           System.out.println(getList44.toString());
           
           return getList44.getGetListResponse().getHotelListResponse().getHotelList();

        }
	
}
