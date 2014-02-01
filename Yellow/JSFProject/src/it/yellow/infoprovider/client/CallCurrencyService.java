package it.yellow.infoprovider.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import net.webservicex.www.CurrencyConvertorStub.ConversionRate;
import net.webservicex.www.CurrencyConvertorStub.ConversionRateResponse;
import net.webservicex.www.CurrencyConvertorStub.Currency;

public class CallCurrencyService {

	public  Double call() throws RemoteException{

		net.webservicex.www.CurrencyConvertorStub stub =
                new net.webservicex.www.CurrencyConvertorStub();//the default implementation should point to the right endpoint
   
    //FIX per errore 411
    stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
       
    	ConversionRate convRate = new ConversionRate();
    	convRate.setFromCurrency(Currency.INR);
    	convRate.setToCurrency(Currency.EUR);
    
       //call
    	ConversionRateResponse res = stub.conversionRate(convRate);
    

       
       System.out.println(res.getConversionRateResult());

       return res.getConversionRateResult();

    }
	
}
