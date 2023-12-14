package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    // çağrıldığı yere bir WebDriver objesi dondürecek
    // getDriver() oluşturalım

    static WebDriver driver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        if (driver==null){
            driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void closeDriver(){
        driver.close();

    }

    public static void quitDriver(){
        driver.quit();

    }



}
