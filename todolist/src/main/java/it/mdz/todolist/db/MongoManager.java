package it.mdz.todolist.db;

import it.mdz.todolist.model.Comment;
import it.mdz.todolist.model.SubTask;
import it.mdz.todolist.model.Task;
import it.mdz.todolist.model.User;
import it.mdz.todolist.util.CryptoUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoManager implements DataManager {

	static Logger logger = LogManager.getLogger(MongoManager.class.getName());
	
	DB db = null;
	
	public MongoManager(){
		db = MongoDB.getInstance().getConnection();
	}
	

	@Override
	public List<User> getUsers() {
		DBCursor cur = db.getCollection("user").find();
		List<User> res = new ArrayList<User>();
		while(cur.hasNext()){
			BasicDBObject dbo = (BasicDBObject)cur.next();
			User u = new User();
			u.set_id(dbo.getObjectId("_id"));
			u.setUserid(dbo.getString("userid"));
			u.setPassword(dbo.getString("password"));
			res.add(u);
		}
		return res;
	}
	
	@Override
	public boolean insertUser(User user) {
		String pwd = null;
		try {
			pwd = CryptoUtil.encodePassword(user.getPassword());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("Error in hasing algorithm", e);
			e.printStackTrace();
			return false;
		}
		BasicDBObject dbo = new BasicDBObject("userid", user.getUserid())
			.append("password", pwd);
		
		DBCollection userColl = db.getCollection("user");
		userColl.insert(dbo);
		
		
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO
		return false;
	}

	@Override
	public boolean deleteUser(String userid) {
		DBCollection userColl = db.getCollection("user");
		BasicDBObject dbo = new BasicDBObject("userid", userid);
		userColl.remove(dbo);//userid è unique
		return true;
	}

	@Override
	public User getUser(String userid) {
		BasicDBObject dbo = (BasicDBObject)db.getCollection("user").findOne(new BasicDBObject("userid", userid));
		User u = new User();
		u.set_id(dbo.getObjectId("_id"));
		u.setUserid(dbo.getString("userid"));
		u.setPassword(dbo.getString("password"));
		return u;
	}

	@Override
	public boolean insertTask(Task task) {
		// TODO Auto-generated method stub
		
		BasicDBObject dbo = new BasicDBObject();
		dbo.append("userid", task.getUserid());
		dbo.append("title", task.getTitle());
		dbo.append("description", task.getDescription());
		dbo.append("number", task.getNumber());
		dbo.append("creationDate", task.getCreationDate());
		dbo.append("dateLimit", task.getDateLimit());
		dbo.append("completed", task.getCompleted());
		dbo.append("outcome", task.getOutcome());
		dbo.append("subtasks", new BasicDBObject());//quando aggiungo un task non posso contestualmente aggiungere subtasks o commenti
		dbo.append("comments", new BasicDBObject());
		
		DBCollection taskColl = db.getCollection("task");
		taskColl.insert(dbo);
		
		return true;
	}

	@Override
	public boolean updateTask(Task task) {
		
		BasicDBObject dbo = new BasicDBObject();
		dbo.append("_id", task.get_id());
		dbo.append("userid", task.getUserid());
		dbo.append("title", task.getTitle());
		dbo.append("description", task.getDescription());
		dbo.append("number", task.getNumber());
		dbo.append("creationDate", task.getCreationDate());
		dbo.append("dateLimit", task.getDateLimit());
		dbo.append("completed", task.getCompleted());
		dbo.append("outcome", task.getOutcome());
		dbo.append("subtasks", new BasicDBObject());//quando aggiungo un task non posso contestualmente aggiungere subtasks o commenti
		dbo.append("comments", new BasicDBObject());
		
		DBCollection taskColl = db.getCollection("task");
		taskColl.update(new BasicDBObject("_id", task.get_id()), dbo);//FIXME: o save?
		
		return true;
	}

	@Override
	public boolean deleteTask(Long number, String userid) {
		DBCollection taskColl = db.getCollection("task");
		BasicDBObject dbo = new BasicDBObject("userid", userid).append("number", number);
		taskColl.remove(dbo);//userid + number è unique
		return true;
	}

	@Override
	public Task getTask(Long number, String userid) {
		BasicDBObject dbo = (BasicDBObject)db.getCollection("task").findOne(new BasicDBObject("userid", userid).append("number", number));
		Task t = new Task();
		t.set_id(dbo.getObjectId("_id"));
		t.setUserid(dbo.getString("userid"));
		t.setTitle(dbo.getString("title"));
		t.setDescription(dbo.getString("description"));
		t.setNumber(dbo.getLong("number"));
		t.setCreationDate(dbo.getDate("creationDate"));
		t.setDateLimit(dbo.getDate("dateLimit"));
		t.setCompleted(dbo.getBoolean("completed"));
		t.setOutcome(dbo.getBoolean("outcome"));
		ArrayList<SubTask> sbt = new ArrayList<SubTask>();
		BasicDBList subtasks = (BasicDBList)dbo.get("subtasks");
		for(Object os: subtasks){
			BasicDBObject s = (BasicDBObject)os;
			SubTask st = new SubTask();
			st.set_id(s.getObjectId("_id"));
			st.setOrder(s.getInt("order"));
			st.setDescription(s.getString("description"));
			st.setCreationDate(s.getDate("creationDate"));
			st.setCompleted(s.getBoolean("completed"));
			st.setOutcome(s.getBoolean("outcome"));
			
			ArrayList<Comment> comm = new ArrayList<Comment>();
			BasicDBList comments = (BasicDBList)dbo.get("comments");
			for(Object oc: comments){
				BasicDBObject c = (BasicDBObject)oc;
				Comment cm = new Comment();
				cm.set_id(c.getObjectId("_id"));
				cm.setOrder(c.getInt("order"));
				cm.setComment(c.getString("comment"));
				cm.setCreationDate(c.getDate("creationDate"));
				comm.add(cm);
			}
			st.setComments(comm);
			
			sbt.add(st);
		}
		t.setSubtasks(sbt);
		
		ArrayList<Comment> comm = new ArrayList<Comment>();
		BasicDBList comments = (BasicDBList)dbo.get("comments");
		for(Object oc: comments){
			BasicDBObject c = (BasicDBObject)oc;
			Comment cm = new Comment();
			cm.set_id(c.getObjectId("_id"));
			cm.setOrder(c.getInt("order"));
			cm.setComment(c.getString("comment"));
			cm.setCreationDate(c.getDate("creationDate"));
			comm.add(cm);
		}
		t.setComments(comm);
		
		return t;
	}

	@Override
	public List<Task> getTasklist(String userid) {
		DBCursor dbc = db.getCollection("task").find();
		ArrayList<Task> tasks = new ArrayList<Task>();
		while(dbc.hasNext()){
			BasicDBObject dbo = (BasicDBObject)dbc.next();
			Task t = new Task();
			t.set_id(dbo.getObjectId("_id"));
			t.setUserid(dbo.getString("userid"));
			t.setNumber(dbo.getLong("number"));
			t.setTitle(dbo.getString("title"));
			tasks.add(t);
		}
		return tasks;	
	}


	@Override
	public boolean addTaskComment(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSubtask(String userid, Task task, SubTask subtask) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSubtask(String userid, Task task, SubTask subtask) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSubtask(String userid, Task task, SubTask subtask) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubTask getSubTask(Long tasknumber, Integer subtaskOrder,
			String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubTask> getSubTasklist(String userid, Long tasknumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSubTaskComment(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}


}
