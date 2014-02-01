package eventImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

import CosEventChannelAdmin.AlreadyConnected;
import CosEventChannelAdmin.ProxyPullSupplierPOA;
import CosEventComm.Disconnected;
import CosEventComm.PullConsumer;

public class ProxyPullSupplierImpl extends ProxyPullSupplierPOA{

	private PullConsumer pullConsumer;
	private boolean flagConn;
	private EventChannelImpl chan;
	
	public ProxyPullSupplierImpl(EventChannelImpl e, ORB orb, POA poa){
		flagConn=false;
		chan=e;
	}
	@Override
	public void connect_pull_consumer(PullConsumer pullConsumer)
			throws AlreadyConnected {
		// TODO Auto-generated method stub
		if(flagConn) throw new AlreadyConnected();
		this.pullConsumer=pullConsumer;
		flagConn=true;
		//questo non sono sicuro che ci vada, ma è l'unico modo per registrare i clients
		chan.registerPullConsumer(this);
	}

	@Override
	public void disconnect_pull_supplier() {
		// TODO Auto-generated method stub
		if(flagConn){
			if(pullConsumer!=null){
				pullConsumer.disconnect_pull_consumer();
				this.pullConsumer=null;
				//ma devo distruggere anche questo oggetto? o no?
				chan.deregister(this);
			}
			flagConn=false;
		}
		else throw new OBJECT_NOT_EXIST();
	}

	@Override
	public Any pull() throws Disconnected {
		// TODO Auto-generated method stub
		return chan.handlePullEvent(this);
	}

	@Override
	public Any try_pull(BooleanHolder hasEvent) throws Disconnected {
		// TODO Auto-generated method stub
		return chan.handleTryPullEvent(this, hasEvent);
	}

}
