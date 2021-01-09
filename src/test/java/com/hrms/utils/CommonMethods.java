package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;

    /**
     * this method will open a browser , set up configuration and navigate to url
     */
    @BeforeMethod(alwaysRun = true)
    public static void setUp(){

        ConfigsReader.readProperties ( Constants.CONFIGURATION_FILEPATH );
        switch (ConfigsReader.getPropertyValue ( "browser" ).toLowerCase ()) {
            case "chrome":
                WebDriverManager.chromedriver ().setup ();
                driver = new ChromeDriver ();
                break;
            case "firefox":
               WebDriverManager.firefoxdriver ().setup ();
                driver = new FirefoxDriver ();
                break;
            default:
                throw new RuntimeException ( "Invalid browser" );
        }
        driver.get(ConfigsReader.getPropertyValue ( "url" ));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
    /**
     * this method will close any open browser
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown(){

        if(driver!=null) {
            driver.quit ( );
        }
        }
       // @Test
               // public void test(){
           // System.out.println (System.getProperty ( "user.dir" ) );
        }





