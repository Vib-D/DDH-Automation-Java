package com.vibhor.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected static Properties OR = new Properties();
    private static FileInputStream fis;
    protected Logger log = Logger.getLogger(this.getClass());

    public void setUp() {
        PropertyConfigurator.configure("./src/test/resources/log4j.properties");
        log.info("Test Execution Started!!!");
        try {
            fis = new FileInputStream("./src/test/resources/OR.properties");
            OR.load(fis);
            log.info("OR properties file loaded!!!");
        } catch (Exception e) {
            log.error("Error loading properties file", e);
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.warn("Error closing FileInputStream", e);
                }
            }
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
            log.error("Invalid Browser Name Provided!!!");
        }
        return browser;
    }

    public void tearDown() {
        if (page != null) {
            page.close();
            log.info("Page closed!!!");
        }
        if (browser != null) {
            browser.close();
            log.info("Browser closed!!!");
        }
        if (playwright != null) {
            playwright.close();
            log.info("Playwright closed!!!");
        }
    }
}
