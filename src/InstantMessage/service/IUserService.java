package InstantMessage.service;

public interface IUserService {

	//validate the user
	public boolean login(String uid,String pwd);
	
	//check the admin
	public boolean isAdmin(String uid);
	
	//get the user name
	public String getNickName(String uid);
	
}
