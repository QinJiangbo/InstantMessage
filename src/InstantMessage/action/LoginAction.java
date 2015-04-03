package InstantMessage.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import InstantMessage.service.IMessageService;
import InstantMessage.service.IUserService;
  
@Component 
@SuppressWarnings("rawtypes")
public class LoginAction extends BaseAction{
	@Autowired
	private IUserService userService; 
	@Autowired
	private IMessageService messageService;
	
	private String uid;
	private String pwd;
	public String getUid() {
		return uid;
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		if(this.userService.login(this.uid, this.pwd)){
			String userType;     //get the user type admin/user
			String nickName;     //get the user nickname
			nickName=this.userService.getNickName(uid);
			if(this.userService.isAdmin(uid)){
				userType="Administrator";
				Map[] messageList=this.messageService.showMessage();
				this.getRequest().put("messageList", messageList);
				this.getSession().put("nickName", nickName);
				this.getSession().put("userType", userType);
				/*Map[] rows=this.messageService.splitPage(3, 1);
				int pageCount=this.messageService.getPageCount(3);
				this.getRequest().put("rows", rows);
				this.getRequest().put("pageCount", pageCount);
				this.getSession().put("currentIndex", 1);*/
				return "admin";
			}else{
				userType="Customer";
				Map[] messageReplyList=this.messageService.showMessageReply(uid);
				this.getSession().put("uid", uid);
				this.getRequest().put("messageReplyList", messageReplyList);
				this.getSession().put("nickName", nickName);
				this.getSession().put("userType", userType);
				return "user";
			}
			
		}
		return "error";
	}




	

}
