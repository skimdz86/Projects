package demo;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CosEventChannelAdmin.EventChannel;
import CosEventChannelAdmin.EventChannelHelper;

import eventImpl.*;

public class CosEventServer3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//create all the servant?
			//inizializza orb
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost","192.168.0.2"};
			ORB orb=ORB.init(a, null);
			//resolve rootpoa
			POA rootPoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPoa.the_POAManager().activate();
			//creare eventchannel eventImpl, gli passo l'orb, forse il poa non serve
			EventChannelImpl chanImpl;
			chanImpl=new EventChannelImpl(orb,rootPoa,0);
			//get object reference from the servant
			org.omg.CORBA.Object ref=rootPoa.servant_to_reference(chanImpl);
			EventChannel ecref=EventChannelHelper.narrow(ref);
			//recupera il root naming context
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContext ncRef= NamingContextExtHelper.narrow(objRef);
			//binding dell'object reference in Naming
			NameComponent path[]=((NamingContextExtOperations) ncRef).to_name("EventChannelServer3");
			ncRef.rebind(path, ecref);
			///operazioni varie
			System.out.println("Channel ready");
			orb.run();//blocca il thread finchè orb non è distrutto!!quindi se devo fare altro istanziare un new Thread
		
		}catch(Exception e){}

	}

}
