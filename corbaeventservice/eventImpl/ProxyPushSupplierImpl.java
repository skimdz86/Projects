package eventImpl;

import org.omg.CORBA.*;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

import CosEventChannelAdmin.AlreadyConnected;
import CosEventChannelAdmin.ProxyPushSupplierPOA;
import CosEventChannelAdmin.TypeError;
import CosEventComm.Disconnected;
import CosEventComm.PushConsumer;

public class ProxyPushSupplierImpl extends ProxyPushSupplierPOA{

	private PushConsumer pushConsumer;
	private boolean flagConn;
	private EventChannelImpl chan;
	////ma qui serve anche passare orb, poa e eventchannel????
	
	public ProxyPushSupplierImpl(EventChannelImpl e, ORB orb, POA poa) {
		super();
		// TODO Auto-generated constructor stub
		flagConn=false;
		chan=e;
	}

	@Override
	public void connect_push_consumer(PushConsumer pushConsumer)
			throws AlreadyConnected, TypeError {
		// TODO Auto-generated method stub
		if(flagConn) throw new AlreadyConnected();
		if(pushConsumer==null) throw new BAD_PARAM();
		this.pushConsumer=pushConsumer;
		flagConn=true;
		//questo non sono sicuro che ci vada, ma è l'unico modo per registrare i clients
		chan.registerConsumer(this);
	}

	@Override
	public void disconnect_push_supplier() {
		// TODO Auto-generated method stub
		if(flagConn){
			if(pushConsumer!=null){
				pushConsumer.disconnect_push_consumer();
				this.pushConsumer=null;
				//ma devo distruggere anche questo oggetto? o no?
			}
			flagConn=false;
		}
		else throw new OBJECT_NOT_EXIST();
	}
	
	protected void pushToConsumer(Any data){
		try {
			pushConsumer.push(data);
		} catch (Disconnected e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected boolean isConsumerConnected(){
		if(this.pushConsumer!=null) return true;
		return false;
	}

}
