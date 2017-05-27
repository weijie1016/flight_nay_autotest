package com.maysunmedia.flight_nay_autotest.testdata;

import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.maysunmedia.flight_nay_autotest.utils.DBHelper;

public class DelayTestDataDriver {
	private static Logger logger = Logger.getLogger(DelayTestDataDriver.class); 
	
	/**
	 * 清表
	 * @param tableName
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void truncateTable(String tableName) throws ClassNotFoundException, SQLException{
		String sql="truncate table "+tableName;
		DBHelper.executeUpdate(sql);
		DBHelper.close();
	}
	
	/**
	 * 导数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void importData() throws ClassNotFoundException, SQLException{
			
		String csvFilePath=System.getProperty("user.dir").replace('\\', '/')+"/src/test/resources/data-200.csv";
		logger.debug("--------------------------------------");
		logger.debug(csvFilePath);
		logger.debug("--------------------------------------");
		String sql="LOAD DATA LOCAL INFILE '"+csvFilePath+"' IGNORE INTO TABLE flight_nay CHARACTER SET utf8 FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 LINES";
		logger.debug(DBHelper.executeUpdate(sql));
		DBHelper.close();
	
	}
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void initTestData() throws ClassNotFoundException, SQLException{
		truncateTable("flight_nay");
		importData();
		
		setCurrentDatetime();
		setNullDatetime();
		
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	private static void setCurrentDatetime() throws ClassNotFoundException, SQLException{
		String sql="UPDATE flight_nay set "
			+"FLIGHT_DATE=IF(SUBSTRING(FLIGHT_DATE,1,10)='0000-00-00', FLIGHT_DATE, CONCAT(DATE(NOW()), ' ',SUBSTRING(FLIGHT_DATE,12,8))),"
			+"START_PLAN=IF(SUBSTRING(START_PLAN,1,10)='0000-00-00', START_PLAN, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_PLAN,12,8))),"
			+"START_PREDICT=IF(SUBSTRING(START_PREDICT,1,10)='0000-00-00', START_PREDICT, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_PREDICT,12,8))),"
			+"START_REAL=IF(SUBSTRING(START_REAL,1,10)='0000-00-00', START_REAL, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_REAL,12,8))),"
			+"TERMINAL_PLAN=IF(SUBSTRING(TERMINAL_PLAN,1,10)='0000-00-00', TERMINAL_PLAN, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_PLAN,12,8))),"
			+"TERMINAL_PRIDICT=IF(SUBSTRING(TERMINAL_PRIDICT,1,10)='0000-00-00', TERMINAL_PRIDICT, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_PRIDICT,12,8))),"
			+"TERMINAL_REAL=IF(SUBSTRING(TERMINAL_REAL,1,10)='0000-00-00', TERMINAL_REAL, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_REAL,12,8))),"
			+"COUNTER_TIME_START=IF(SUBSTRING(COUNTER_TIME_START,1,10)='0000-00-00', COUNTER_TIME_START, CONCAT(DATE(NOW()), ' ',SUBSTRING(COUNTER_TIME_START,12,8))),"
			+"COUNTE_TIME_END=IF(SUBSTRING(COUNTE_TIME_END,1,10)='0000-00-00', COUNTE_TIME_END, CONCAT(DATE(NOW()), ' ',SUBSTRING(COUNTE_TIME_END,12,8)))";
		DBHelper.executeUpdate(sql);
		DBHelper.close();
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	private static void setNullDatetime() throws ClassNotFoundException, SQLException{
		String sql="UPDATE flight_nay set "
			+"FLIGHT_DATE=IF(FLIGHT_DATE='0000-00-00 00:00:00', NULL, FLIGHT_DATE),"
			+"START_PLAN=IF(START_PLAN='0000-00-00 00:00:00', NULL, START_PLAN),"
			+"START_PREDICT=IF(START_PREDICT='0000-00-00 00:00:00', NULL, START_PREDICT),"
			+"START_REAL=IF(START_REAL='0000-00-00 00:00:00', NULL, START_REAL),"
			+"TERMINAL_PLAN=IF(TERMINAL_PLAN='0000-00-00 00:00:00', NULL, TERMINAL_PLAN),"
			+"TERMINAL_PRIDICT=IF(TERMINAL_PRIDICT='0000-00-00 00:00:00', NULL, TERMINAL_PRIDICT),"
			+"TERMINAL_REAL=IF(TERMINAL_REAL='0000-00-00 00:00:00', NULL, TERMINAL_REAL),"
			+"COUNTER_TIME_START=IF(COUNTER_TIME_START='0000-00-00 00:00:00', NULL, COUNTER_TIME_START),"
			+"COUNTE_TIME_END=IF(COUNTE_TIME_END='0000-00-00 00:00:00', NULL, COUNTE_TIME_END)";
		DBHelper.executeUpdate(sql);
		DBHelper.close();
	}
}
