package com.automationjiraproject2.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static  {
        try {
            //2- we need to open the file in java memory:FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- load the properties object using File InputStream
            properties.load(file);

            file.close();

        }catch(IOException e){
            System.out.println("file not found in the ConfigurationReader class ");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
