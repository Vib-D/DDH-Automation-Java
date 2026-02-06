package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
    private  Playwright playwright;
    public  Browser browser;
    public Page page;
    private static Properties OR = new Properties();
    private static FileInputStream fis;
    private Logger log = Logger.getLogger(this.getClass());

    
    public void setUp() {
        PropertyConfigurator.configure("./src/test/properties/log4j.properties");
        log.info("Test Execution Started!!!");
        try {
            fis = new FileInputStream("./src/test/properties/OR.properties");
            OR.load(fis);
            log.info("OR properties file loaded!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Browser getBrowser(String browserName) {
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chromium")) {
            browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
            log.info("Chromium Browser Launched!!!");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
            log.info("Firefox Browser Launched!!!");
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browser = playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
            log.info("Webkit Browser Launched!!!");
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return browser;
    }
        

}
