package com.sipho.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties  = new Properties();

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        }

    }

    public String getMyApplicationURL() {
        String url = properties.getProperty("baseURL");
        return url;
    }

    public String getUsername(){
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        return password;
    }

    public String getChromepath(){
        String chromepath = properties.getProperty("chromepath");
        return chromepath;
    }

   public String getIEPath(){
        String iePath = properties.getProperty("iepath");
        return iePath;
   }

   public String getFirefoxPath(){
        String firefoxpath = properties.getProperty("firefoxpath");
        return firefoxpath;
   }

   public String getSiteTitle(){
        String WebsiteTitle = properties.getProperty("WebsiteTitle");
        return WebsiteTitle;
   }
}
