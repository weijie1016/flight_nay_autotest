package com.maysunmedia.flight_nay_autotest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DBHelper {
	private static String url=null;
	private static String name=null;
	private static String user=null;
	private static String password=null;

	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs=null;
	private static Logger logger = Logger.getLogger(DBHelper.class); 
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException{

			PropUtils prop = new PropUtils("db.properties");
			url=prop.get("db_url");
			name=prop.get("db_driver");
			user=prop.get("db_user");
			password=prop.get("db_password");
			
			logger.debug("--------------------------------------------------------");
			logger.debug("url:"+url);
			logger.debug("name:"+name);
			logger.debug("user:"+user);
			logger.debug("password:"+password);
			logger.debug("--------------------------------------------------------");
//			
//			
//			url="jdbc:mysql://127.0.0.1:3306/ceeety_flight_test?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
//			name="com.mysql.cj.jdbc.Driver";
//			user="root";
//			password="";		
			Class.forName(name);
			conn=DriverManager.getConnection(url, user, password);
			return conn;
	}
	
	
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException{
		pst=getConnection().prepareStatement(sql);
		rs=pst.executeQuery();
		return rs;
	}
	
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int executeUpdate(String sql) throws ClassNotFoundException,SQLException {
		int result;
		pst=getConnection().prepareStatement(sql);
		result=pst.executeUpdate();
		return result; 
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	public static void close() throws SQLException{
		if(rs!=null){
			rs.close();
			rs=null;
		}
		if(pst!=null){
			pst.close();
			pst=null;
		}
		if(conn!=null){
			conn.close();
			conn=null;
		}
	}
}