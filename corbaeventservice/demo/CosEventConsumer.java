package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import eventImpl.*;

import CosEventChannelAdmin.*;
import CosEventComm.*;

public class CosEventConsumer extends PushConsumerImpl{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CosEventConsumer x=new CosEventConsumer();
	}
	
	public CosEventConsumer(){
		
		PushConsumerImpl pushConImpl=new PushConsumerImpl();
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
				
				//create and initializse orb
				String[] a={"-ORBInitialPort","1050","-ORBInitialHost",address};
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
				//String name="EventChannelServer";
				//EventChannel ec=EventChannelHelper.narrow(((NamingContextExtOperations) ncRef).resolve_str(name));
				EventChannel ec=EventChannelHelper.narrow(orb.string_to_object("corbaname::"+address+":1050#"+channelName));
				//devo attaccare this all'orb
				NameComponent path[]=((NamingContextExtOperations)ncRef).to_name("Consumer");
				ncRef.rebind(path, obj);
				
				//operations here!
				/*final ClientOps cImpl=new ClientOps();
				new Thread(){
					public void run(){
						cImpl.startOps(ec);
					}
				}.start();*/
				//orb.run();//ma a che serve questo?
				System.out.println("consumer connesso a orb");
				//creo un proxy del supplier e mi connetto al consumer creato prima
				ConsumerAdmin consumerAdmin = null;
				try{
					consumerAdmin=ec.for_consumers();
				}catch(Exception e){
					System.out.println("ERRORE: il topic non esiste!");
					return;
				}	
				final ProxyPushSupplier pps=consumerAdmin.obtain_push_supplier();
				pps.connect_push_consumer(pcref);
				System.out.println("consumer connesso al canele");
				//qui bisogna che attendela print: lo fa orb.run()!!(forse)
				
				//
				new Thread(){
					public void run(){
						boolean flag=true;
						InputStreamReader inp2=new InputStreamReader(System.in);
						BufferedReader in2=new BufferedReader(inp2);
						String command="";
						while(flag){
							System.out.println("Scrivi \"exit\" per disconnetterti");
							try {
								command=in2.readLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(command.equals("exit")){
								flag=false;
								pps.disconnect_push_supplier();
							}
						}
					}	
				}.start();
				
				//Thread.sleep(15000);
				//pps.disconnect_push_supplier();
				
				//orb.run();
				
				}catch(Exception e){e.printStackTrace();}


	}

}
