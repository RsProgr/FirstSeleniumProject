package com.homework.Hw15.fw;

import com.homework.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    UserHelper user;
    ShoppingCartHelper shoppingCart;
    HomePageHelper homePage;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test start in Chrome brwser");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Test start in Firefox brwser");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Test start in Edge brwser");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        shoppingCart = new ShoppingCartHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ShoppingCartHelper getShoppingCart() {
        return shoppingCart;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        driver.quit();

    }
}