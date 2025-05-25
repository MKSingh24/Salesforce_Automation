package com.salesforce.context;

import com.salesforce.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory {
    WebDriver driver;
    String browserFromPropertyFile=ConfigReader.getProperty("browser");
    String browserFromMaven=System.getProperty("browser");
    //outcome=condition?value1:value2
    String browser=browserFromMaven!=null?browserFromMaven:browserFromPropertyFile;

    public WebDriver getDriver() {
        if(driver==null) {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
                driver.manage().window().maximize();
            } else if(browser.equalsIgnoreCase("chrome_headless")){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless","disable-gpu","--window-size=1920,1080");
                driver = new ChromeDriver(options);
            } else if(browser.equalsIgnoreCase("chrome_incognito")){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--incognito","--start-maximized");
                driver = new ChromeDriver(options);
            } else if(browser.equalsIgnoreCase("edge_headless")){
                EdgeOptions options=new EdgeOptions();
                options.addArguments("headless","window-size=1920,1080");
                driver=new EdgeDriver(options);
            } else if(browser.equalsIgnoreCase("edge_inprivate")){
                EdgeOptions options=new EdgeOptions();
                options.addArguments("inprivate","start-maximized");
                driver=new EdgeDriver(options);
            }
        }
        return driver;
    }

    public void launchBrowser(String url){
        driver.get(url);

    }
}
