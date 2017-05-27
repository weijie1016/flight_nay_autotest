package com.maysunmedia.flight_nay_autotest.testcases;

import java.lang.ArrayIndexOutOfBoundsException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.maysunmedia.flight_nay_autotest.pageobjects.D1Page;
import com.maysunmedia.flight_nay_autotest.testdata.DelayTestDataDriver;



import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DelayTest extends BaseTest {
	private static Logger logger = Logger.getLogger(DelayTest.class); 
	@Test
	public void testDelayDegree() throws SQLException, ClassNotFoundException {
		 driver.get("http://192.168.1.232:2000/#/D1");
		 driver.manage().window().maximize();
		 D1Page d1Page=new D1Page(driver);
		 Assert.assertEquals(d1Page.getAllFlightsDelayOrNot(), "小面积延误");
		// d1Page.getAllFlightsData();

//		DelayTestDataDriver.initTestData();
	}
	//初始化大面积延误，小面积延误，流量正常数据
//	private void initialTestData() throws SQLException, ClassNotFoundException{
		
		//修改FLIGHT_DATE字段为当前日期
		//修改计划起飞时间
		//修改预计起习时间
		//
//		String sql_update_flight;
//		Date now = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
//		Calendar gc = new GregorianCalendar();
//		gc.setTime(now);
//		for (int i = 0; i < 200; i++) {
//			gc.add(Calendar.MINUTE, -300 + i * 3);
//			sql_update_flight="update flight_nay set start_plan='"+dateFormat.format(gc.getTime())+"' where flight_id="+(5000+i); 
//			logger.debug(sql_update_flight);
//			DBHelper.setSql(sql_update_flight);
//			DBHelper.executeUpdate();
//			gc.setTime(now);
//		}
//		
		
//	}
}
