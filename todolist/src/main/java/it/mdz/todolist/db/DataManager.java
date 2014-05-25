package it.mdz.todolist.db;

import it.mdz.todolist.model.SubTask;
import it.mdz.todolist.model.Task;
import it.mdz.todolist.model.User;

import java.util.List;

public interface DataManager {

	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String userid);
	public User getUser(String userid);
	
	public boolean insertTask(Task task);
	public boolean updateTask(Task task);
	public boolean deleteTask(Long number, String userid);
	public Task getTask(Long number, String userid);
	public List<Task> getTasklist(String userid);
	
	public boolean addSubtask(String userid, Task task, SubTask subtask);
	public boolean deleteSubtask(String userid, Task task, SubTask subtask);
	public boolean updateSubtask(String userid, Task task, SubTask subtask);
	public SubTask getSubTask(Long tasknumber, Integer subtaskOrder, String userid);
	public List<SubTask> getSubTasklist(String userid, Long tasknumber);
	
	
}
