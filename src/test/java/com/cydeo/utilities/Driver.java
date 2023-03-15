package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){

    }

    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>();


    public static WebDriver getDriver(){
        if (driverPool.get()==null){


            String browserType= ConfigurationReader.getProperty("browser");


            switch (browserType){
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("intl.accept_languages", "en-GB");
                    options.setExperimentalOption("prefs", prefs);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }


        return driverPool.get();
    }


    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();

            driverPool.remove();
        }

    }

}
