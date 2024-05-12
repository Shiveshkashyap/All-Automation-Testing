package com.inetbanking.testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig(){

        File src = new File("./Configuration/Configuration.properties");
//        for reading the data from properties file we need fileInputstream to get read access
//        Using try cath is easy to take data if any Exception we will print .

        try {
            FileInputStream fileInputStream = new FileInputStream(src);// it help to open the file and read it
            properties=new Properties();
            properties.load(fileInputStream);// it is load all the file data in run time.
        }
        catch (Exception e){
            System.out.println("Exception is :"+ e.getMessage());// if some dat is missing it will get exception
        }

    }
//     after tha we have to create method for all the property which is present in Properties file . Below example:
     public String getApplicationUrl(){
        String url = properties.getProperty("baseURL");
        return url;
     }

     public String getUserName(){
        String username = properties.getProperty("Username");
        return username;
     }
     public String getPassword(){
        String pass = properties.getProperty("password");
        return pass;
     }
    public String getTitle(){
        String Title = properties.getProperty("Desc");
        return Title;
    }



}
