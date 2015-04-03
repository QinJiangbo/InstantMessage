package InstantMessage.service;

import java.util.Map;

@SuppressWarnings("rawtypes")
public interface IMessageService {

	public Map[] splitPage(int pageSize,int pageIndex);
	public int getPageCount(int pageSize );
	public void sendMessage(String message,String uid);
	public Map[] showMessage();
	public Map[] showMessageReply(String uid);
	public void replyMessage(String messageReply,String messageID);
}
