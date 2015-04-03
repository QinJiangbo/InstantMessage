package InstantMessage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import InstantMessage.dao.IDbhelper;

@Component(value="userService")
@SuppressWarnings("rawtypes")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IDbhelper dao;
	public boolean login(String uid, String pwd) {
		String sql="select count(*) n from userinfo where userid=? and password=?";
		Object[] params={uid,pwd};
		Map row=dao.runSelect(sql, params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n==1;
	}
	
	public boolean isAdmin(String uid) {
		String sql="select isAdmin from userinfo where userid=?";
		Object[] params={uid};
		Map row=this.dao.runSelect(sql, params)[0];
		int i=Integer.parseInt(row.get("isAdmin").toString());
		return i==1;
	}

	public String getNickName(String uid){
		String sql="select nickname from userinfo where userid=?";
		Object[] params={uid};
		Map row=this.dao.runSelect(sql, params)[0];
		String nickName=row.get("nickname").toString();
		return nickName;
	}

}
