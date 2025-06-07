package com.salesforce.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {
        try{
            FileInputStream fis=new FileInputStream("src/test/resources/glpbal.properties") ;
          //  FileInputStream fis=new FileInputStream(System.getProperty("dir.user")+"src\\test\\resources\\glpbal.properties") ;
            properties=new Properties();
            properties.load(fis);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Fails to load config file");

        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}
