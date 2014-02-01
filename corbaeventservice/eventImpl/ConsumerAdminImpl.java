package eventImpl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import CosEventChannelAdmin.ConsumerAdminPOA;
import CosEventChannelAdmin.ProxyPullSupplier;
import CosEventChannelAdmin.ProxyPullSupplierHelper;
import CosEventChannelAdmin.ProxyPushConsumer;
import CosEventChannelAdmin.ProxyPushSupplier;
import CosEventChannelAdmin.ProxyPushSupplierHelper;
import CosEventChannelAdmin.ProxyPushSupplierPOA;

public class ConsumerAdminImpl extends ConsumerAdminPOA{

	EventChannelImpl chan;
	ORB orb;
	POA poa;
	
	public ConsumerAdminImpl(EventChannelImpl e, ORB orb, POA poa) {
		super();
		// TODO Auto-generated constructor stub
		chan=e;
		this.orb=orb;
		this.poa=poa;

	}

	@Override
	public ProxyPullSupplier obtain_pull_supplier() {
		// TODO Auto-generated method stub
		ProxyPullSupplierImpl p=new ProxyPullSupplierImpl(chan, orb, poa);
		org.omg.CORBA.Object ref=null;
		try {
			ref=poa.servant_to_reference(p);
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProxyPullSupplier obj=ProxyPullSupplierHelper.narrow(ref);
		return obj;
	}

	@Override
	public ProxyPushSupplier obtain_push_supplier() {
		// TODO Auto-generated method stub
		ProxyPushSupplierImpl p=new ProxyPushSupplierImpl(chan, orb, poa);
		org.omg.CORBA.Object ref=null;
		try {
			ref=poa.servant_to_reference(p);
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProxyPushSupplier obj=ProxyPushSupplierHelper.narrow(ref);
		//consList.add(p);
		return obj;
	}
	
}
