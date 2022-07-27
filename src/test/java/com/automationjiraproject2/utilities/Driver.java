package com.automationjiraproject2.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    /*
    we make webdriver private because we want to close access from outside a class
     we make it static because we will use it in static method
     */
    // private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    create a reuasable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if(driverPool.get()==null){

            /*
            we read our browserType from configuration.properties.
            this way, we can control which browser is opened from outside our code from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            depending on the browserType taht will be return from configuration.properties file
            switch statement will determine the case, and open the matching browser
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        return driverPool.get();
    }
    /*
    this method make sure our driver value is
    always null after using quit() method
     */
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
