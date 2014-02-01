package eventImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

import CosEventChannelAdmin.AlreadyConnected;
import CosEventChannelAdmin.ProxyPullConsumerPOA;
import CosEventChannelAdmin.TypeError;
import CosEventComm.Disconnected;
import CosEventComm.PullSupplier;

public class ProxyPullConsumerImpl extends ProxyPullConsumerPOA{

	private PullSupplier pullSupplier;
	private boolean flagConn;
	private EventChannelImpl chan;
	
	public ProxyPullConsumerImpl(EventChannelImpl e, ORB orb, POA poa){
		flagConn=false;
		chan=e;
	}
	
	@Override
	public void connect_pull_supplier(PullSupplier pullSupplier)
			throws AlreadyConnected, TypeError {
		// TODO Auto-generated method stub
		if(flagConn) throw new AlreadyConnected();
		if(pullSupplier==null) throw new BAD_PARAM();
		this.pullSupplier=pullSupplier;
		flagConn=true;
		//questo non sono sicuro che ci vada, ma è l'unico modo per registrare i clients
		chan.registerPullSupplier(this);
	}

	@Override
	public void disconnect_pull_consumer() {
		// TODO Auto-generated method stub
		if(flagConn){
			if(pullSupplier!=null){
				pullSupplier.disconnect_pull_supplier();
				pullSupplier=null;
			}
			flagConn=false;
		}
		else throw new OBJECT_NOT_EXIST();
	}
	
	protected Any pullFromSupplier() throws Disconnected{
		return pullSupplier.pull();
	}

	public boolean isSupplierConnected() {
		// TODO Auto-generated method stub
		if(this.pullSupplier!=null) return true;
		return false;
	}
	public void push(Any data){
		
	}

}
