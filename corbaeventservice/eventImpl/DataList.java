package eventImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Any;

import Data.DataListPOA;

public class DataList implements Serializable{
	
	Any[] a;
	public List t;//il public è temporaneo, solo per test
	
	public DataList(){
		t=new ArrayList<Any>();
	}
	
	public void insertData(Any data){
		t.add(data);
	}
	public List returnList(){
		/*for(int i=0;i<t.size();i++){
			a[i]=(Any) t.get(i);
		}
		return a;*/
		return t;
	}
	public List getList(){//di test
		return t;
	}

}
