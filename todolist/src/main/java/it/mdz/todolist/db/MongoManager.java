package it.mdz.todolist.db;

import it.mdz.todolist.model.SubTask;
import it.mdz.todolist.model.Task;
import it.mdz.todolist.model.User;
import it.mdz.todolist.util.CryptoUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class MongoManager implements DataManager {

	static Logger logger = LogManager.getLogger(MongoManager.class.getName());
	
	DB db = null;
	
	public MongoManager(){
		db = MongoDB.getInstance().getConnection();
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
		return false;
	}

	@Override
	public boolean updateTask(Task task) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTask(Long number, String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Task getTask(Long number, String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasklist(String userid) {
		// TODO Auto-generated method stub
		return null;
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

}
