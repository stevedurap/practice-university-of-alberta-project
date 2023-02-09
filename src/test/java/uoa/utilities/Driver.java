package uoa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Creating a private constructor, we are closing access to the object of this class from outside the class

    private Driver() {
    }


    private static WebDriver driver; // value is null by default


    public static WebDriver getDriver() {


        if (driver == null) {


            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return driver;

    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }

    }

}
