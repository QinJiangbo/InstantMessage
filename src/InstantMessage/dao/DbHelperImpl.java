package InstantMessage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.sql.DataSource;

@SuppressWarnings("rawtypes")
public class DbHelperImpl implements IDbhelper {

	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getConnection(){		
		try{
			Connection conn=dataSource.getConnection();
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public Map[] runSelect(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			int i=1;//really easy to be wrong!!!
			for(Object o:params){
				if(o ==null){
				   ps.setObject(i++,o,java.sql.Types.VARCHAR); 
				}else{
				   ps.setObject(i++,o); 
				}
			}					 	
			rs=ps.executeQuery();
			Result result=ResultSupport.toResult(rs);
			Map[] rows=result.getRows();			
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ 
			try{
				rs.close();
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
		
	
	public Map[] runSelect(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Result result=ResultSupport.toResult(rs);
			Map[] rows=result.getRows();			
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ 
			try{
				rs.close();
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	
	public void runUpdate(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{ 
			try{
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	
	public void runUpdate(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			int i=1;//really easy to be wrong!!!
			for(Object o:params){
				if(o ==null){
				   ps.setObject(i++,o,java.sql.Types.VARCHAR); 
				}else{
				   ps.setObject(i++,o); 
				}
			}		
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{ 
			try{
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	
}
