package InstantMessage.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("rawtypes")
public class BaseAction {

	public Map getRequest(){
		return (Map)ActionContext.getContext().get("request");
	}
	
	public Map getSession(){
		return (Map)ActionContext.getContext().get("session");
	}
}
