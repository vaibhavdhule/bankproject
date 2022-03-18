package com.bankproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File f = new File("F:\\BankFramwork\\com.bankproject.www\\Properties\\config.properties");

		try {

			FileInputStream fis = new FileInputStream(f);

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getUrl() {

		String url = pro.getProperty("baseurl");

		return url;
	}

	public String getChromePath() {

		String chromepath = pro.getProperty("chromepath");

		return chromepath;
	}

	public String getFirefoxPath() {

		String firefoxpath = pro.getProperty("firefoxpath");

		return firefoxpath;
	}

	public String getIEPath() {

		String iepath = pro.getProperty("iepath");

		return iepath;
	}

}
