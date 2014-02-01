package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CosEventComm.*;
import CosEventChannelAdmin.*;

import eventImpl.*;

public class CosEventSupplier {
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			
			PushSupplierImpl pushSuppImpl=new PushSupplierImpl();
			
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost","localhost"};
			ORB orb=ORB.init(a, null);
			POA rootPoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPoa.the_POAManager().activate();
			//questo serve a dare un supplier a cui connettersi dopo
			org.omg.CORBA.Object obj=rootPoa.servant_to_reference(pushSuppImpl);
			PushSupplier psref = PushSupplierHelper.narrow(obj);
		
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContext ncRef= NamingContextExtHelper.narrow(objRef);
		
			String name="EventChannelServer";
			final EventChannel ec=EventChannelHelper.narrow(((NamingContextExtOperations) ncRef).resolve_str(name));
			//operations here!
			/*final ClientOps cImpl=new ClientOps();
			new Thread(){
				public void run(){
					cImpl.startOps(ec);
				}
			}.start();*-/
			orb.run();//ma a che serve questo?
		
			//creo un proxy del consumer e mi connetto al supplier creato prima
			SupplierAdmin supplierAdmin=ec.for_suppliers();
			ProxyPushConsumer ppc=supplierAdmin.obtain_push_consumer();
			ppc.connect_push_supplier(psref);
			
			
			//ora devo chiamare la push sul consumer....
			Any data = null;
			data.insert_string("boh");
			ppc.push(data);
		
			}catch(Exception e){e.printStackTrace();}
	}*/
	
	public static void main(String[] args) {
		PushSupplierImpl pushSuppImpl=new PushSupplierImpl();
		String address="192.168.0.2";
		try{
			System.out.println("A quale topic ti vuoi connettere? Digita 1 2 o 3");
			InputStreamReader inp=new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(inp);
			String choose;
			do{
				choose=in.readLine();
			}while(!choose.equals("1") && !choose.equals("2") && !choose.equals("3"));//cosi controllo che inserisca solo canali esistenti
			String channelName="EventChannelServer"+choose;
			
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost",address};
			ORB orb=ORB.init(a, null);
			POA poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			//questo serve a dare un supplier a cui connettersi dopo
			org.omg.CORBA.Object obj=poa.servant_to_reference(pushSuppImpl);
			PushSupplier psref = PushSupplierHelper.narrow(obj);
		
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContext ncRef= NamingContextExtHelper.narrow(objRef);
		
			//String name="EventChannelServer";
			//EventChannel ec=EventChannelHelper.narrow(((NamingContextExtOperations) ncRef).resolve_str(name));
			EventChannel ec=EventChannelHelper.narrow(orb.string_to_object("corbaname::"+address+":1050#"+channelName));
			//devo attaccare this all'orb
			NameComponent path[]=((NamingContextExtOperations)ncRef).to_name("Supplier");
			ncRef.rebind(path, obj);
			
			//operations here!
			/*final ClientOps cImpl=new ClientOps();
			new Thread(){
				public void run(){
					cImpl.startOps(ec);
				}
			}.start();*/
			//orb.run();//ma a che serve questo?
		System.out.println("connesso a orb supplier");
			//creo un proxy del consumer e mi connetto al supplier creato prima
			SupplierAdmin supplierAdmin;
			try{
				supplierAdmin=ec.for_suppliers();
			}catch(Exception e){
				System.out.println("ERRORE: il topic selezionato non esiste!!");
				return;
			}
			ProxyPushConsumer ppc=supplierAdmin.obtain_push_consumer();
			System.out.println("fino a qui va");
			System.out.println(ppc.toString());
			ppc.connect_push_supplier(psref);///////////controllare qui
			System.out.println("supplier connesso al canale");
			//example
			System.out.println("Scrivere \"exit\" per disconnettere il supplier");
			while(true){
			
				String x=in.readLine();
				if(x.equals("exit")) {
					ppc.disconnect_push_consumer();
					break;
				}
				//ora devo chiamare la push sul consumer....
				else{
					Any data = orb.create_any();
					data.insert_string(x);
					ppc.push(data);
				}
			}
			
			//Thread.sleep(1000);
			//ppc.disconnect_push_consumer();
		
			}catch(Exception e){e.printStackTrace();}

	}

}
