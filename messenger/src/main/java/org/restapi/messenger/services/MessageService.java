package org.restapi.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restapi.messenger.database.DatabaseClass;
import org.restapi.messenger.model.Message;

public class MessageService{

	private Map<Long,Message>messages=DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1,"hi","Subham"));
		messages.put(2L,new Message(2,"hello","Najmin"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0)
			return null;
		else {
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message deleteMessage(Long id) {
		return messages.remove(id);
	}
}
