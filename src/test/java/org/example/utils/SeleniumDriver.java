package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

public class SeleniumDriver {

    public static WebDriver setLocalDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = WebDriverManager.chromedriver().create();
//        WebDriverManager.chromedriver().clearDriverCache().setup();
        return new ChromeDriver(options);
    }

    public static RemoteWebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
            put("enableVNC", true);
            put("enableLog", true);
            put("noSandbox", true);
            put("headless", true);
        }});
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub").toURL(), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteDriver;
    }
}