package com.waes.heros.profiles.support;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

private Properties properties;
private final String propertyFilePath= "src//test//resources//configuration.properties";

public PropertiesFileReader(){
    BufferedReader reader;
    try {
    reader = new BufferedReader(new FileReader(propertyFilePath));
    properties = new Properties();
    try {
    properties.load(reader);
    reader.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
    } catch (FileNotFoundException e) {
    e.printStackTrace();
    throw new RuntimeException("Configuration.properties not found at " + propertyFilePath); }
    } 

    public String getDriverPath(){
        String driverPath = properties.getProperty("driver.path");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the configuration.properties file for the Key:driver.path"); 
        }

    public String getApplicationUrl() {
            String url = properties.getProperty("heros.profiles.url");
            if(url != null) return url;
            else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
            }

    public String getWindowSize(){
            String windowSize = properties.getProperty("window.size.maximized");
            if(windowSize != null) return windowSize;
            else throw new RuntimeException("Application windowSize not specified in the configuration.properties file for the Key:window.size.maximized");
    }

	public int getImplicitWait() {
        String strImplicitWait = properties.getProperty("implicit.wait.time.seconds");
        int implicitWait = Integer.valueOf(strImplicitWait);
        if(implicitWait >= 0 ) return implicitWait;
        else throw new RuntimeException("Application windowSize not specified in the configuration.properties file for the Key:window.size.maximized");
	
	}

}