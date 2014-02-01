package eventImpl;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.StringSeqHelper;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import CosEventComm.Disconnected;
import CosEventComm.PullSupplierPOA;
import Data.DataListHelper;

public class PullSupplierImpl extends PullSupplierPOA{

	DataList d;
	ORB orb;
	String buffer;
	POA poa;
	
	public PullSupplierImpl(POA poa) {
		super();
		// TODO Auto-generated constructor stub
		d=new DataList();
		this.poa=poa;
		
	}

	public synchronized void insertData(Any any){
		d.insertData(any);
		for(int i=0;i<d.getList().size();i++){
			Any xxx = (Any) d.getList().get(i);
			System.out.println(xxx.extract_string());
			
		}
		System.out.println("---------");
		//notifyAll();//se nella pull metto il wait()
	}
	public void fillBuffer(String s){
		buffer=s;
	}
	
	@Override
	public void disconnect_pull_supplier() {
		// TODO Auto-generated method stub
		System.out.println("Pull supplier disconnesso");
	}

	@Override
	public Any pull() throws Disconnected {
		// TODO Auto-generated method stub
		Any any=orb.create_any();
		List a=d.returnList();
		
		while(a.size()==0){
			//do nothing, bloccante finché non ci sono dati
			//uso una sleep, cosi il ciclo non spreca troppa cpu
			try {
				Thread.sleep(1000);
				//wait();//forse meglio cosi, ma non so se va coi trhead
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] s=new String[a.size()];
		for(int i=0;i<a.size();i++){
			s[i]=((Any)a.get(i)).extract_string();
		}
		StringSeqHelper.insert(any, s);
		//cosi ho inserito un oggetto serializzabile, forse
		//any.insert_Value(d);//argh! il cast non va: devo mettere datalist nell'idl?
		//any.insert_string(buffer);
		return any;
	}

	@Override
	public Any try_pull(BooleanHolder hasEvent) throws Disconnected {
		// TODO Auto-generated method stub
		/*Any[] a=d.returnList();
		if(a.length>0){
			hasEvent.value=true;
			//do something
			return null;//qualcosa;
		}
		else {
			hasEvent.value=false;
			return null;
		}*/return null;
	}

	public void setOrb(org.omg.CORBA.ORB orb) {
		// TODO Auto-generated method stub
		this.orb=orb;
	}

}
