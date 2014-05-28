package it.mdz.todolist.rest;

import java.util.List;

import it.mdz.todolist.core.ApplicationCore;
import it.mdz.todolist.db.DataManager;
import it.mdz.todolist.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {

	ApplicationCore app = new ApplicationCore();
	DataManager dmgr = app.getDataManager();
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		return dmgr.getUsers();
	}
	
	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userid") String userid){
		return dmgr.getUser(userid);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean addUser(User user){
		boolean b = dmgr.insertUser(user);
		return new Boolean(b);
	}
}
