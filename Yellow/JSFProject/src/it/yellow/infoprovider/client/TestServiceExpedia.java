package it.yellow.infoprovider.client;

import org.apache.axis2.client.Options;

import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetList;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListE;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.HotelListRequest;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.Room;
import com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.RoomGroup;

public class TestServiceExpedia {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestServiceExpedia t = new TestServiceExpedia();
		t.testgetList();
	}
	
	public  void testgetList() throws java.lang.Exception{

        com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub stub =
                    new com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub();//the default implementation should point to the right endpoint

//        Options options = new Options();
//        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
       
        //FIX per errore 411
        stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
        //devo popolare la request!!!
        
           GetListE getList0 = new GetListE();
           HotelListRequest req = new HotelListRequest();
           req.setApiKey("XXXXXXXXXXXXXXXXXXXXXXXXXX");
           req.setCid(55505);
           req.setCustomerIpAddress("79.17.154.169");
           req.setCustomerUserAgent("Mozilla/Firefox 5.0");
           req.setCity("Gorgonzola");
           req.setCountryCode("IT");
           req.setDepartureDate("06/30/2012");
           req.setArrivalDate("06/23/2012");
           
           RoomGroup roomGroup = new RoomGroup();
           Room room = new Room();
           room.setNumberOfAdults(2);
           roomGroup.addRoom(room);
           req.setRoomGroup(roomGroup);
           
           GetList param = new GetList();
           param.setHotelListRequest(req);
           
           getList0.setGetList(param);
           
           //call
           com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE getList44=
                                                        (com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE)stub.getList(getList0);
        

           
           System.out.println(getList44.toString());

        }

	
	//Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
       return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    
}
