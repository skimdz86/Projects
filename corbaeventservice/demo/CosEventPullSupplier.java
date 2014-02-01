package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CosEventChannelAdmin.EventChannel;
import CosEventChannelAdmin.EventChannelHelper;
import CosEventChannelAdmin.ProxyPullConsumer;
import CosEventChannelAdmin.ProxyPushConsumer;
import CosEventChannelAdmin.SupplierAdmin;
import CosEventComm.PullSupplier;
import CosEventComm.PullSupplierHelper;
import CosEventComm.PushSupplier;
import CosEventComm.PushSupplierHelper;

import eventImpl.PullSupplierImpl;
import eventImpl.PushSupplierImpl;

public class CosEventPullSupplier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PushSupplierImpl pushSuppImpl;
		String address="192.168.0.2";
		try{
			System.out.println("A quale topic ti vuoi connettere? Digita 1 2 o 3");
			InputStreamReader inp=new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(inp);
			String choose;
			do{
				choose=in.readLine();
			}while(!choose.equals("1") && !choose.equals("2") && !choose.equals("3"));//cosi controllo che inserisca solo canali esistenti
			String channelName="EventChannelPullServer"+choose;
			
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost",address};
			ORB orb=ORB.init(a, null);
			POA poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			
			pushSuppImpl=new PushSupplierImpl();
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
			//pullSuppImpl.setOrb(orb);//pure questo, a che serve?
			
		System.out.println("connesso a orb supplier");
			//creo un proxy del consumer e mi connetto al supplier creato prima
			SupplierAdmin supplierAdmin=ec.for_suppliers();
			ProxyPushConsumer ppc=supplierAdmin.obtain_push_consumer();
			System.out.println("fino a qui va");
			System.out.println(ppc.toString());
			ppc.connect_push_supplier(psref);///////////controllare qui
			System.out.println("supplier connesso al canale");
			//example
			
			while(true){
			
				String x=in.readLine();
				if(x.equals("exit")){
					ppc.disconnect_push_consumer();
					break;
				}
				else{
					Any any=orb.create_any();
					any.insert_string(x);
					/*pullSuppImpl.insertData(any);*/
					//nulla di tutto cio; spedisco direttamente al canale uno per volta i dati
					ppc.push(any);
				}
				
			}
			
			//Thread.sleep(1000);
			//ppc.disconnect_pull_consumer();
		
			}catch(Exception e){e.printStackTrace();}

	}


}
