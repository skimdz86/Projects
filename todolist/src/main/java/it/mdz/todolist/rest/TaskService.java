package it.mdz.todolist.rest;

import it.mdz.todolist.core.ApplicationCore;
import it.mdz.todolist.db.DataManager;

import javax.ws.rs.Path;

@Path("/task")
public class TaskService {
	ApplicationCore app = new ApplicationCore();
	DataManager dmgr = app.getDataManager();
	
	
}
