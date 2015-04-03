package InstantMessage.service;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import InstantMessage.dao.IDbhelper;

@Component(value="shopService")
@SuppressWarnings("rawtypes")
public class MessageServiceImpl implements IMessageService {
	@Autowired
    private IDbhelper dao;	
	
	public Map[] splitPage(int pageSize, int pageIndex) {
		String sql="select * from (select * from message where rownum<=?*?) ";
		sql=sql+"where messageid not in ( select messageid from message where rownum<=(?-1)*?)";     	
        Object[] params={pageIndex,pageSize,pageIndex,pageSize};
		return this.dao.runSelect(sql, params);
	}
	public int getPageCount(int pageSize) {
		String sql="select ceil(count(*)/?) n from message";
		Object[] params={pageSize};
		Map row=this.dao.runSelect(sql, params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n;
	}

	public void sendMessage(String message,String uid) {
		String sql="insert into message values('',?,sysdate,?)";
		Object[] params={uid,message};
		this.dao.runUpdate(sql, params);
	}
	
	public Map[] showMessage() {
		String sql="select b.nickname,a.*,c.ReplyContent from message a,userinfo b,messageReply c where a.userid=b.userid and a.messageid=c.messageid(+)";
		Map[] rows=this.dao.runSelect(sql);
		return rows;
	}
	
	public Map[] showMessageReply(String uid) {
		String sql="select b.nickname,a.*,c.ReplyContent from message a,userinfo b,messageReply c where a.userid=b.userid and a.messageid=c.messageid(+) and a.userid=?";
		Object[] params={uid};
		Map[] rows=this.dao.runSelect(sql,params);
		return rows;
	}
	
	public void replyMessage(String messageReply, String messageID) {
		String sql="insert into messageReply values('',?,sysdate,?)";
		Object[] params={messageID,messageReply};
		this.dao.runUpdate(sql, params);
	}
	
}