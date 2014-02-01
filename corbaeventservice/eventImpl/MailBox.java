package eventImpl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Any;

public class MailBox {

	List<Any> l;
	ProxyPullSupplierImpl p;
	
	public MailBox(ProxyPullSupplierImpl p){
		this.p=p;
		l=new ArrayList<Any>();
	}
	
	public List<Any> returnList(){
		return l;
	}
	public void insertData(Any a){
		l.add(a);
	}
	public void clear(){//verra chiamata quando il client fa la pull
		l.clear();
	}
	public void destroy(){//ma si puo fare?
		this.destroy();
	}
	public ProxyPullSupplierImpl getProxy(){
		return p;
	}
}
