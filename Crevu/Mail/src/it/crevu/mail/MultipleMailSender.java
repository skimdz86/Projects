package it.crevu.mail;

import java.util.List;

public class MultipleMailSender {

	public void sendMassiveMail(List<String> recipients, String subject, String textMsg){
		
		MailSender sender = new MailSender();
		
		for(String rec: recipients){
			sender.sendMail(rec, subject, textMsg);
		}
	}
}
