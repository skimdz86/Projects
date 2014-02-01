package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.Any;
import org.omg.CORBA.AnySeqHelper;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.StringSeqHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;

import CosEventChannelAdmin.ConsumerAdmin;
import CosEventChannelAdmin.EventChannel;
import CosEventChannelAdmin.EventChannelHelper;
import CosEventChannelAdmin.ProxyPullSupplier;
import CosEventComm.PullConsumer;
import CosEventComm.PullConsumerHelper;

//import eventImpl.DataList;
import eventImpl.PullConsumerImpl;

public class CosEventPullConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CosEventPullConsumer x=new CosEventPullConsumer();
	}
	
	public CosEventPullConsumer(){
		
		PullConsumerImpl pushConImpl=new PullConsumerImpl();
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
				
				//create and initializse orb
				String[] a={"-ORBInitialPort","1050","-ORBInitialHost",address};
				ORB orb=ORB.init(a, null);
				
				POA Poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
				Poa.the_POAManager().activate();
				//questo serve a dare un consumer a cui connettersi dopo
				org.omg.CORBA.Object obj=Poa.servant_to_reference(pushConImpl);//il servant è xxxImpl
				PullConsumer pcref = PullConsumerHelper.narrow(obj);
				
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
				ConsumerAdmin consumerAdmin=ec.for_consumers();
				ProxyPullSupplier pps=consumerAdmin.obtain_pull_supplier();
				pps.connect_pull_consumer(pcref);
				System.out.println("consumer connesso al canele");
				//chiamare la pull da qui
				while(true){
					System.out.println("Scrivere \"exit\" per disconnettere il consumer, \"pull\" o \"trypull\" per ottenere un dato");
					String s1=in.readLine();
					if(s1.equals("exit")){
						pps.disconnect_pull_supplier();
						break;
					}
					if(s1.equals("pull")){
						Any x=pps.pull();
						Any[] mess = AnySeqHelper.extract(x);
						for(int j=0;j<mess.length;j++){
							String sx=mess[j].extract_string();
							System.out.println(sx);
						}
						/*
						//qui ora ho una lista per ogni publisher, con all'interno una lista di messaggi
						Serializable res = x.extract_Value();
						DataList d1 = (DataList) res;//errore wrong adapter:non piu coi serializable
						//sembra sia un bug, che succede se la funzione ref_to_serv viene chiamata su un poa 
						//diverso da quello che chiamò serv_to_ref
						List t1,t2;
						//Any[] a1=d1.returnList();//lista di supplier's list
						System.out.println(d1.t.size());
						Thread.sleep(2500);
						//t1=new ArrayList<Any>(Arrays.asList(a1));
						t1=d1.returnList();
						for(int i=0;i<t1.size();i++){
							Any y=(Any) (t1.get(i));
							Serializable res2 = y.extract_Value();
							DataList d2=(DataList) res2;
							//Any[] a2=d2.returnList();//lista di eventi per ogni supplier
							//t2=new ArrayList<Any>(Arrays.asList(a2));
							
							t2=d2.returnList();
							for(int j=0;j<t2.size();j++){
								Any z=(Any) t2.get(j);
								String s=z.extract_string();
								System.out.println(s);//stringa rappresentante l'evento
							}
						}*/
					}
					if(s1.equals("trypull")){
						BooleanHolder bh=new BooleanHolder();
						Any x=pps.try_pull(bh);//ma si usa cosi il booleanhoder??
						if(bh.value){
							Any[] mess = AnySeqHelper.extract(x);
							for(int j=0;j<mess.length;j++){
								String sx=mess[j].extract_string();
								System.out.println(sx);
							}
						}
						else System.out.println("Non ci sono messaggi");
					}
				}
				
				//
				//Thread.sleep(15000);
				//pps.disconnect_pull_supplier();
				
				//orb.run();
				
				}catch(Exception e){e.printStackTrace();}


	}


}
