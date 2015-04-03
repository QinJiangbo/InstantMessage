package InstantMessage.dao;

import java.util.Map;

@SuppressWarnings("rawtypes")
public interface IDbhelper {

	public Map[] runSelect(String sql,Object[] params);
	public Map[] runSelect(String sql);
	public void runUpdate(String sql);
	public void runUpdate(String sql,Object[] params);
}
