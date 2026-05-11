package com.orange.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	private static final Logger log = LoggerFactory.getLogger(Config.class);
	private static final String DEFAULT_PROPERTIES = "config/default.properties";
	private static Properties properties;
	
	
	public static void initialize() {
			
			//load default properties
			properties = loadProperties();
			
			// Override default properties if the same key is provided as a Java system property (-Dkey=value)
			for(String key: properties.stringPropertyNames()) {
				if(System.getProperties().containsKey(key)) {
					properties.setProperty(key, System.getProperty(key));
				}
			}
			
			//print
			log.info("Test Properties");
			log.info("---------------------------------------");
			for(String key: properties.stringPropertyNames()) {
				log.info("{}={}", key, properties.getProperty(key));
			}
			log.info("---------------------------------------");			
		}
		
	public static String get(String key) {
		return properties.getProperty(key);
}   // Loads the default properties file into a Properties object.
	// It reads the file using ResourceLoader, parses all key-value pairs,
	// handles any exceptions during reading, and returns the populated Properties object.
	private static Properties loadProperties() {
		Properties properties = new Properties();
		try(InputStream stream = ResourceLoader.getSource(DEFAULT_PROPERTIES)){
			properties.load(stream);
	}catch (Exception e) {
		log.error("unable to read the property file{}",DEFAULT_PROPERTIES, e);			
	}
		return properties;
}
	}