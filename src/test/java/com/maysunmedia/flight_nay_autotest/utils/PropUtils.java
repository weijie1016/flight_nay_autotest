package com.maysunmedia.flight_nay_autotest.utils;

import java.io.InputStreamReader;
import java.util.Properties;

public class PropUtils {
	private Properties props;

	public PropUtils(String fileName) {
		readProperties(fileName);
	}

	private void readProperties(String fileName) {
		try {
			props = new Properties();
			InputStreamReader inputStream = new InputStreamReader(
					this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
			props.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String get(String key) {
        return props.getProperty(key);
    }
	
	
	
	
	
	
	
}
