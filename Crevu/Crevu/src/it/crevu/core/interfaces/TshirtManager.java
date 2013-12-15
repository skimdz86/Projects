package it.crevu.core.interfaces;

import java.util.List;

public interface TshirtManager {
	
	public void saveTshirt(Integer userId,String text,List<String> tags, String source, Integer votes, boolean bad);

}
