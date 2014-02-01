package eventImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CosEventChannelAdmin.*;
import CosEventComm.*;


public class PushConsumerImpl extends PushConsumerPOA{

	@Override
	public void disconnect_push_consumer() {
		// TODO Auto-generated method stub
		System.out.println("Push Consumer disconnesso");
		
	}

	@Override
	public void push(Any data) throws Disconnected {
		// TODO Auto-generated method stub
		String d=data.extract_string();
		System.out.println(d);
	}
	/*
	public static void main(String[] args) {
		PushConsumerImpl pushConImpl=new PushConsumerImpl();
		
	}
	public PushConsumerImpl(){
		
		try{
					
			//create and initializse orb
			String[] a={"-ORBInitialPort","1050","-ORBInitialHost","localhost"};
			ORB orb=ORB.init(a, null);
			
			POA Poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			Poa.the_POAManager().activate();
			//questo serve a dare un consumer a cui connettersi dopo
			org.omg.CORBA.Object obj=Poa.servant_to_reference(pushConImpl);//il servant è xxxImpl
			PushConsumer pcref = PushConsumerHelper.narrow(obj);
			
			//get root naming context
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContext ncRef= NamingContextExtHelper.narrow(objRef);
			//resolve object reference in naming
			String name="EventChannelServer";
			EventChannel ec=EventChannelHelper.narrow(((NamingContextExtOperations) ncRef).resolve_str(name));
			
			//operations here!
			/*final ClientOps cImpl=new ClientOps();
			new Thread(){
				public void run(){
					cImpl.startOps(ec);
				}
			}.start();*-/
			//orb.run();//ma a che serve questo?
			System.out.println("consumer connesso a orb");
			//creo un proxy del supplier e mi connetto al consumer creato prima
			ConsumerAdmin consumerAdmin=ec.for_consumers();
			ProxyPushSupplier pps=consumerAdmin.obtain_push_supplier();
			pps.connect_push_consumer(pcref);
			System.out.println("consumer connesso al canele");
			orb.run();
			
			}catch(Exception e){e.printStackTrace();}

	}*/

}
