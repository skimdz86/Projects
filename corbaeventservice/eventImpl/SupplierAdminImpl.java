package eventImpl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import CosEventChannelAdmin.ProxyPullConsumer;
import CosEventChannelAdmin.ProxyPullConsumerHelper;
import CosEventChannelAdmin.ProxyPushConsumer;
import CosEventChannelAdmin.ProxyPushConsumerHelper;
import CosEventChannelAdmin.SupplierAdminPOA;
import CosEventComm.PushConsumer;

public class SupplierAdminImpl extends SupplierAdminPOA{

	EventChannelImpl chan;
	ORB orb;
	POA poa;
	
	public SupplierAdminImpl(EventChannelImpl e, ORB orb, POA poa) {
		super();
		// TODO Auto-generated constructor stub
		chan=e;
		this.orb=orb;
		this.poa=poa;
	}

	@Override
	public ProxyPullConsumer obtain_pull_consumer() {
		// TODO Auto-generated method stub
		ProxyPullConsumerImpl p=new ProxyPullConsumerImpl(chan, orb, poa);
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
		ProxyPullConsumer obj = ProxyPullConsumerHelper.narrow(ref);
		//suppList.add(p);
		return obj;
	}

	@Override
	public ProxyPushConsumer obtain_push_consumer() {
		// TODO Auto-generated method stub
		ProxyPushConsumerImpl p=new ProxyPushConsumerImpl(chan, orb, poa);
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
		ProxyPushConsumer obj = ProxyPushConsumerHelper.narrow(ref);
		//suppList.add(p);
		return obj;
	}

}
