package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    protected static WebDriver driver;

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

    /**
     * this method will clear a textbox and send text to it
     * @param element
     * @param textToSEnd
     */
      public static void sendText(WebElement element,String textToSEnd){
        element.clear ();
        element.sendKeys ( textToSEnd );
      }

    /**
     * this method will return an object an objcet of explicit wait with time set to 20 sec
     * @return
     */

      public static WebDriverWait getWait(){
          WebDriverWait wait=new WebDriverWait ( driver,Constants.EXPLICIT_WAIT );
          return wait;
      }
    /**
     * this method will wait intil given element becomes clickable
     * @param element
     */
      public static void waitForClickability(WebElement element){
          getWait ().until ( ExpectedConditions.elementToBeClickable ( element ) );
      }
    /**
     * this method will wait and then click
     * @param element
     */
      public static void click(WebElement element){
          waitForClickability ( element );
          element.click ();
      }

    /**
     * this method will return an object of JavascriptExecutor
     * @return JavascriptExecutor
     */

      public static JavascriptExecutor getJSExecutor(){
          JavascriptExecutor js=(JavascriptExecutor)driver;
          return js;
      }

    /**
     *
     * @param element
     */

      public static void JSclick(WebElement element){
          getJSExecutor ().executeScript ( "arguments[0].click",element );
      }


        }





