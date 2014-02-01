package eventImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

import CosEventChannelAdmin.AlreadyConnected;
import CosEventChannelAdmin.ProxyPushConsumerPOA;
import CosEventComm.Disconnected;
import CosEventComm.PushSupplier;

public class ProxyPushConsumerImpl extends ProxyPushConsumerPOA{

	private PushSupplier pushSupplier;
	private boolean flagConn=false;
	private EventChannelImpl chan;
	
	public ProxyPushConsumerImpl(EventChannelImpl e, ORB orb, POA poa) {
		super();
		// TODO Auto-generated constructor stub
		chan=e;
	}

	@Override
	public void connect_push_supplier(PushSupplier pushSupplier)//connect TO supplier
			throws AlreadyConnected {
		// TODO Auto-generated method stub
		if(flagConn) throw new AlreadyConnected();
		this.pushSupplier=pushSupplier;
		flagConn=true;
		//questo non sono sicuro che ci vada, ma è l'unico modo per registrare i clients
		chan.registerSupplier(this);
	}

	@Override
	public void disconnect_push_consumer() {//disconnect THE consumer
		// TODO Auto-generated method stub
		if(flagConn){
			if(pushSupplier!=null){
				pushSupplier.disconnect_push_supplier();
				pushSupplier=null;
			}
			flagConn=false;
		}
		else throw new OBJECT_NOT_EXIST();
	}

	@Override
	public void push(Any data) throws Disconnected {
		// TODO Auto-generated method stub
		if(!flagConn) throw new Disconnected();
		chan.handleEvent(data);
	}

}
