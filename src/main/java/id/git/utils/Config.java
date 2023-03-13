package id.git.utils;

import java.util.Properties;

import org.apache.log4j.Logger;

import id.git.model.Database;

public class Config {
	private static Logger log = Logger.getLogger(Config.class.getName());
	public static boolean init() {
		Properties prop = Files.getProperties("config.properties");
		if (prop.isEmpty()) {
			return false;
		}

		Database.configure(prop);

		prop.clear();
		return true;
	}

}
