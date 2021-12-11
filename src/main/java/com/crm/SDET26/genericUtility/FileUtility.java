package com.crm.SDET26.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Chan
 *
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
   	 FileInputStream fis = new FileInputStream("./src/test/resources/VtigerLogin.properties");
   	 Properties pObj = new Properties();
   	 pObj.load(fis);
   	 String value = pObj.getProperty(key);
	 return value;
   	
   }
}


