package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CosEventChannelAdmin.*;
import CosEventComm.*;

public class ClientOps {

	public void startOps(EventChannel chan){
		while(true){
			System.out.println("Inserire:\n1. per pubblicare un messaggio\n2. per registrare un supplier\n3. per registrare un consumer\n");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String m1="";
			try {
				m1 = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(m1.equals("1")){
			}
			if(m1.equals("2")){
				
			}
			if(m1.equals("3")){
				
			}
			
		}

	}
}
