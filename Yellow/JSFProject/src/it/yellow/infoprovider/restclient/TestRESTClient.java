package it.yellow.infoprovider.restclient;

import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.ParseException;

import com.cleartrip.air.AirSearchResult;

public class TestRESTClient {
	
	
	public void callClearTrip() throws ParseException, IOException, JAXBException{
		String url = "http://api.staging.cleartrip.com/air/1.0/search";
		//ricordarsi l'uri escape
		String paramString = "from=FCO" +
				"&to=MXP" +
				"&depart-date=2012-07-04" +
				"&return-date=2012-07-09" +
				"&adults=3" +
				"&cabin-type=Business";
		
//		String uri = url+"?"+paramString;
//			URL url2 = new URL(uri);
//			HttpURLConnection connection = 
//			    (HttpURLConnection) url2.openConnection();
//			connection.setRequestMethod("GET");
//			connection.addRequestProperty("X-CT-API-KEY", "30850e35b55fc06af39e6fd9c8ea5dc6");
//			connection.setRequestProperty("Accept", "application/xml");
//			 
//			JAXBContext jc = JAXBContext.newInstance(AirSearchResult.class);
//			InputStream xml = connection.getInputStream();
//			AirSearchResult searchRes = 
//			    (AirSearchResult) jc.createUnmarshaller().unmarshal(xml);
//			 
//			connection.disconnect();
//		System.out.println(searchRes);
		WebClient client=WebClient.create(url+"?"+paramString);
        client.header("X-CT-API-KEY", "30850e35b55fc06af39e6fd9c8ea5dc6");
        client.accept("application/xml");
//        Response res = client.get();
//        ResponseBuilder builder = Response.fromResponse(res);
//        builder.
//        System.out.println(result);
//        Response respo = client.get();
        AirSearchResult res2 = client.get(AirSearchResult.class);
			
	//		        --prima bisogna prendere gli xsd sul sito e crearsi i bean corrisp!!!
//        XMLSource source = client.get(XMLSource.class);
//        source.setBuffering(true);
//        AirSearchResult res = source.getNode("/air-search-result", AirSearchResult.class);
//        System.out.println(res);
        //lancia una webapp exception senza spiegazioni se sbagli i parametri data (minori di oggi)
        
//        ListIterator<Object> solutionList = res.getSolutionsOrOnwardSolutionsOrReturnSolutions().listIterator();
//        while(solutionList.hasNext()){
//        	Solution solution = (Solution)solutionList.next();
//        }
//        
        System.out.println(res2.toString());
	}
	
	
	public static void main(String[] args) throws ParseException, IOException, JAXBException{
		TestRESTClient trc = new TestRESTClient();
//		trc.callExpedia();
		trc.callClearTrip();
	}
}
