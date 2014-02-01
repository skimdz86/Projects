package eventImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CosEventChannelAdmin.*;
import CosEventComm.*;

public class PushSupplierImpl extends PushSupplierPOA{

	@Override
	public void disconnect_push_supplier() {
		// TODO Auto-generated method stub
		System.out.println("Push Supplier disconnesso");
		//distruggere qualche reference
	}
	
	/*public static void main(String[] args) {
		PushSupplierImpl pushSuppImpl=new PushSupplierImpl();
	}
	public PushSupplierImpl(){
		try{
			
			
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost","localhost"};
			ORB orb=ORB.init(a, null);
			POA poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			//questo serve a dare un supplier a cui connettersi dopo
			org.omg.CORBA.Object obj=poa.servant_to_reference(this);
			PushSupplier psref = PushSupplierHelper.narrow(obj);
		
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContext ncRef= NamingContextExtHelper.narrow(objRef);
		
			//String name="EventChannelServer";
			//EventChannel ec=EventChannelHelper.narrow(((NamingContextExtOperations) ncRef).resolve_str(name));
			EventChannel ec=EventChannelHelper.narrow(orb.string_to_object("corbaname::localhost:1050#EventChannelServer"));
			//devo attaccare this all'orb
			NameComponent path[]=((NamingContextExtOperations)ncRef).to_name("Supplier");
			ncRef.rebind(path, obj);
			
			//operations here!
			/*final ClientOps cImpl=new ClientOps();
			new Thread(){
				public void run(){
					cImpl.startOps(ec);
				}
			}.start();*-/
			//orb.run();//ma a che serve questo?
		System.out.println("connesso a orb supplier");
			//creo un proxy del consumer e mi connetto al supplier creato prima
			SupplierAdmin supplierAdmin=ec.for_suppliers();
			ProxyPushConsumer ppc=supplierAdmin.obtain_push_consumer();
			System.out.println("fino a qui va");
			//ppc.connect_push_supplier(psref);///////////controllare qui
			PushSupplier y = PushSupplierHelper.narrow(poa.servant_to_reference(this));
			System.out.println("mah chissa perche");
			ppc.connect_push_supplier(y);
			System.out.println("supplier connesso al canale");
			
			//ora devo chiamare la push sul consumer....
			Any data = orb.create_any();
			data.insert_string("boh");
			ppc.push(data);
		
			}catch(Exception e){e.printStackTrace();}

	}*/

}
