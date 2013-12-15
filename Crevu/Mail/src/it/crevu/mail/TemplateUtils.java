package it.crevu.mail;

import java.util.HashMap;

public class TemplateUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String completeMessage(String text, HashMap<String, String> items){
		
		String completeText = text;
		
		for(String key: items.keySet()){
			completeText = completeText.replaceAll("<"+key+">", items.get(key));
		}
		
		return completeText;
	}
	
}
