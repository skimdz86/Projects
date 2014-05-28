package it.mdz.todolist.core;

import it.mdz.todolist.db.DataManager;
import it.mdz.todolist.db.MongoManager;

public class ApplicationCore {

	DataManager dmgr;
	
	public ApplicationCore(){
		dmgr = new MongoManager();
	}
	
	public DataManager getDataManager(){
		return dmgr;
	}
}
