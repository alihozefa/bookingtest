package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Page {

    public static WebDriver driver;
    public static Properties config  = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public String browserType;

    public Page() {

        if(driver==null){
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties");
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            try{
                config.load(fis);
                log.info("Config file loaded!");
            } catch (IOException e){
                e.printStackTrace();
            }

            if(System.getenv("browserType") != null){
                browserType = System.getenv("browserType");
            }else {
                browserType = config.getProperty("browserType");
            }

            if (browserType.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("Chrome instantiated!");
            }else if (browserType.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("firefox instantiated!");
            }else if (browserType.equalsIgnoreCase("ie")){
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                log.info("ie instantiated!");
            }

            driver.get(config.getProperty("testURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),TimeUnit.SECONDS);
        }
    }

    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    public WebElement explicitWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(config.getProperty("explicitWait")));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
