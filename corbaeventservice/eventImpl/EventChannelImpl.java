package eventImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Any;
import org.omg.CORBA.AnySeqHelper;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.StringSeqHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import CosEventChannelAdmin.ConsumerAdmin;
import CosEventChannelAdmin.ConsumerAdminHelper;
import CosEventChannelAdmin.EventChannelPOA;
import CosEventChannelAdmin.ProxyPushConsumer;
import CosEventChannelAdmin.ProxyPushSupplier;
import CosEventChannelAdmin.SupplierAdmin;
import CosEventChannelAdmin.SupplierAdminHelper;
import CosEventComm.Disconnected;
import CosEventComm.PushConsumer;
import CosEventComm.PushSupplier;

public class EventChannelImpl extends EventChannelPOA{

	SupplierAdminImpl sad;
	ConsumerAdminImpl cad;
	POA poa;
	ORB orb;
	List suppList;
	List consList;
	int flag;
	List<MailBox> mail;
	
	public EventChannelImpl(ORB orb, POA rootPoa, int flag) {//flag=0: metodo push; flag=1: metodo pull
		super();
		// TODO Auto-generated constructor stub
		poa=rootPoa;
		this.orb=orb;
		this.flag=flag;
		sad=new SupplierAdminImpl(this, orb, rootPoa);
		cad=new ConsumerAdminImpl(this, orb, rootPoa);
		mail=new ArrayList<MailBox>();
		if(flag==1){//caso pull/mix
			suppList=new ArrayList<ProxyPullSupplierImpl>();
			consList=new ArrayList<ProxyPushConsumerImpl>();
		}
		else{//caso push
			suppList=new ArrayList<ProxyPushSupplierImpl>();
			consList=new ArrayList<ProxyPushConsumerImpl>();
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//distruggere le liste e tutti i riferimebti interni
		if(flag==1){//caso pull
			//disconnetto tutti i proxypullsupplier
			for(int i=0;i<suppList.size();i++){
				((ProxyPullSupplierImpl)suppList.get(i)).disconnect_pull_supplier();
			}
			//disconnetto tutti i proxypushconsumer
			for(int i=0;i<consList.size();i++){
				((ProxyPushConsumerImpl)consList.get(i)).disconnect_push_consumer();
			}
		}
		else{//caso push
			//disconnetto tutti i proxypushsupplier
			for(int i=0;i<suppList.size();i++){
				((ProxyPushSupplierImpl)suppList.get(i)).disconnect_push_supplier();
			}
			//disconnetto tutti i proxypushconsumer
			for(int i=0;i<consList.size();i++){
				((ProxyPushConsumerImpl)consList.get(i)).disconnect_push_consumer();
			}
		}
		//elimno le liste
		suppList=null;
		consList=null;
		sad=null;
		cad=null;
		//e ci va magari una exit da questo oggetto anche  per distruggerlo?
		this.destroy();//ma si può fare=?
	}

	@Override
	public ConsumerAdmin for_consumers() {
		// TODO Auto-generated method stub
		try {
			return ConsumerAdminHelper.narrow(poa.servant_to_reference(cad));
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SupplierAdmin for_suppliers() {
		// TODO Auto-generated method stub
		try {
			return SupplierAdminHelper.narrow(poa.servant_to_reference(sad));
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected void handleEvent(Any data){
		//qui pero dovrei avere la lista di supplieradmin ( o Consumeradmin?) e pushare a tutti
		//List temp=cad.getSuppliers();
		//List temp=suppList;
		if(flag==1){//il flag mi diceva se il canale è per la push o per la pull/mixed: =1 è pull
			storeEvent(data);
		}
		else{//push
			for(int j=0;j<suppList.size();j++){
				if(!((ProxyPushSupplierImpl)suppList.get(j)).isConsumerConnected()){
					suppList.remove(j);
				}//cosi elimino se disconnessi, e non spreco spazio nelle liste
			}
			for(int i=0;i<suppList.size();i++){
				
				if(((ProxyPushSupplierImpl)suppList.get(i)).isConsumerConnected()){
					//System.out.println(data.extract_string());
					((ProxyPushSupplierImpl)suppList.get(i)).pushToConsumer(data);///il problema è tutto qui:
					//la register qua sotto mette in lista dei pushsupplier, ma io qui ho bisogno di proxy invece
			
					//test
					/*Any x=orb.create_any();
					x.insert_string("SONO CONNESSO");
					((ProxyPushSupplierImpl)temp.get(i)).pushToConsumer(x);*/
				}
			}
		}//else
		
	}
	private void storeEvent(Any data) {
		// TODO Auto-generated method stub
		//qui devo avere un array per ogni consumer: lo chiamo mailbox
		synchronized (mail) {
			for(int i=0;i<mail.size();i++){
				((MailBox)mail.get(i)).insertData(data);
				//qui forse una notifyAll(), ma anche no
				
			}
			mail.notifyAll();
		}
	}

	protected synchronized void registerConsumer(ProxyPushSupplierImpl supplier){////ora va
		suppList.add(supplier);
	}
	protected synchronized void registerSupplier(ProxyPushConsumerImpl consumer){
		consList.add(consumer);//ma sta funzione è inutile
	}
	
	protected Any handlePullEvent(ProxyPullSupplierImpl proxyPullSupplierImpl){
		/*
		//chiamo la pull su proxypullconsumer
		Any any=orb.create_any();
		DataList d=new DataList();
		List tempList=new ArrayList<ProxyPullConsumerImpl>();// = consList;
		List mexList=new ArrayList<String>();//tiene tutti i messaggi di tutti i supplier
		synchronized(consList){//è uno spreco, ma qui devo toccare la lista originale
			for(int j=0;j<consList.size();j++){
				if(!((ProxyPullConsumerImpl)consList.get(j)).isSupplierConnected()){
					consList.remove(j);
				}//cosi elimino se disconnessi, e non spreco spazio nelle liste
			}
			//copio in una temporanea, cosi poi non si blocca consList quando viene chiamata pulllFromSupplier
			tempList.clear();
			for(int k=0;k<consList.size();k++){
				tempList.add(consList.get(k));
			}
		}//fine synchro
		for(int i=0;i<tempList.size();i++){
			
			if(((ProxyPullConsumerImpl)tempList.get(i)).isSupplierConnected()){
				//System.out.println(data.extract_string());
				Any x=orb.create_any();
				try {
					x = ((ProxyPullConsumerImpl)tempList.get(i)).pullFromSupplier();//e qua bisogna decidere: se ogni supplier rotorna una lista, qui poi ritorno una lista di oggetti lista
					//potrei mettere tutte le stringhe assieme, chissenefrega di che supplier sono
					String[] mexArray = StringSeqHelper.extract(x);
					for(int v=0;v<mexArray.length;v++){
						mexList.add(mexArray[v]);
					}
				} catch (Disconnected e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}///il problema è tutto qui:
				d.insertData(x);
			}
		}
		//inserire nella datalist ogni risutato delle pull
		//serializable d
		//any.insert_Value(d);
		String mess[]=new String[mexList.size()];
		for(int v=0;v<mexList.size();v++){
			mess[v]=(String) mexList.get(v);
		}
		StringSeqHelper.insert(any, mess);
		return any;
		*///OLD VERSION
		List<Any> temp;
		Any mess[];
		Any res=orb.create_any();
		//sistemare la sincronizzazione dell accesso!!
		List<MailBox> tempMail=new ArrayList<MailBox>();
		//for(int j=0;j<mail.size();j++){
		//	tempMail.add(mail.get(j));//è per evitare una sincro dopo
		//}//poi sistemare e fare le azioni su tempmail: ma la clear?quella la devo fare su mail, come faccio?
		synchronized (mail) {//se non va bene togliere la synchro qui e in storeevent e lasciare solo la sleep qua dentro
			for(int i=0;i<mail.size();i++){
				if(((MailBox)mail.get(i)).getProxy().equals(proxyPullSupplierImpl)){//cioè quando trova nella lista il proxy a cui mandare le cose
					MailBox waitObj =((MailBox)mail.get(i));
					while(waitObj.returnList().size()==0){/////////////ma waitobj è un riferimento, cosi se cambio un attributo poi lo vede anche qui=?opppure se non riassegno l'oggetto returnlist ha sempre size=0?
						//nothing, forse una wait()
						try {
							mail.wait();
							//Thread.sleep(500);//temporaneo, perche il notify non va
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					temp=((MailBox)mail.get(i)).returnList();
					mess=new Any[temp.size()];
					for(int v=0;v<temp.size();v++){
						mess[v]=(Any)temp.get(v);
					}
					AnySeqHelper.insert(res, mess);
					((MailBox)mail.get(i)).clear();
				}
			}
		}
		
		return res;
	}
	protected Any handleTryPullEvent(ProxyPullSupplierImpl proxyPullSupplierImpl, BooleanHolder boolres){
		List<Any> temp;
		Any mess[];
		Any res=orb.create_any();
		//sistemare la sincronizzazione dell accesso!!
		List<MailBox> tempMail=new ArrayList<MailBox>();
		//for(int j=0;j<mail.size();j++){
		//	tempMail.add(mail.get(j));//è per evitare una sincro dopo
		//}//poi sistemare e fare le azioni su tempmail: ma la clear?quella la devo fare su mail, come faccio?
		for(int i=0;i<mail.size();i++){
			if(((MailBox)mail.get(i)).getProxy().equals(proxyPullSupplierImpl)){//cioè quando trova nella lista il proxy a cui mandare le cose
				MailBox mailObj =((MailBox)mail.get(i));
				if(mailObj.returnList().size()>0){
					temp=((MailBox)mail.get(i)).returnList();
					mess=new Any[temp.size()];
					for(int v=0;v<temp.size();v++){
						mess[v]=(Any)temp.get(v);
					}
					AnySeqHelper.insert(res, mess);
					((MailBox)mail.get(i)).clear();
					boolres.value=true;
				}//fine if
			}
		}
		return res;
	}

	public synchronized void registerPullSupplier(ProxyPullConsumerImpl pullConsumer) {// mai usata
		// TODO Auto-generated method stub
		consList.add(pullConsumer);
	}

	public synchronized void registerPullConsumer(ProxyPullSupplierImpl pullSupplier) {
		// TODO Auto-generated method stub
		suppList.add(pullSupplier);
		MailBox x=new MailBox(pullSupplier);
		mail.add(x);
	}

	public void deregister(ProxyPullSupplierImpl proxyPullSupplierImpl) {//solo per il metodo pull/mixed
		// TODO Auto-generated method stub
		for(int i=0;i<suppList.size();i++){
			if(((ProxyPullSupplierImpl)suppList.get(i)).equals(proxyPullSupplierImpl)) {
				suppList.remove(i);
				break;
			}
		}
	}

}
