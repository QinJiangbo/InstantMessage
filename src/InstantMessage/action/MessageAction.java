package InstantMessage.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import InstantMessage.service.IMessageService;
import InstantMessage.service.IUserService;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MessageAction extends BaseAction{
	@Autowired
	private IUserService userService; 
	@Autowired
	private IMessageService messageService;
	
	private String[] messageReply;
	private String[] messageID; 
	private String uid;
	private String message;
	public String[] getMessageReply() {
		return messageReply;
	}

	public void setMessageReply(String[] messageReply) {
		this.messageReply = messageReply;
	}

	public String[] getMessageID() {
		return messageID;
	}

	public void setMessageID(String[] messageID) {
		this.messageID = messageID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String replyMessage()
	{
		//reply the message and prevent the user sending empty message
		for(int i=0;i<messageReply.length;i++)
		{
			if(messageReply[i].isEmpty()){
				
			}else
			{
				this.messageService.replyMessage(messageReply[i], messageID[i]);
			}
		}
		Map[] messageList=this.messageService.showMessage();
		this.getRequest().put("messageList", messageList);
		return "admin";
	}
	
	public String askQuestion()
	{
		//pose the answer prevent the user sending empty message
		if(message.isEmpty()){
			
		}else
		{
			this.messageService.sendMessage(message, uid);
		}
		Map[] messageReplyList=this.messageService.showMessageReply(uid);
		this.getRequest().put("messageReplyList", messageReplyList);
		return "user";
	}
	
}
