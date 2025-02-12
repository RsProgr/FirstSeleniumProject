// Lesson Nr:12 Task:2
//Создайте, пожалуйста, новый тестовый класс,
// где вы будете открывать страничку сайта
//и находить там десять элементов по tagName, id и className

package com.ait.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorkTwo{
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
    }


    @Test
public void   findElementsByTagName(){


        driver.findElement(By.tagName("a"));

        List<WebElement> elements = driver.findElements(By.tagName("li"));
        System.out.println(elements.size());

        List<WebElement> elements1 = driver.findElements(By.tagName("ul"));
        System.out.println(elements1.size());

        driver.findElement(By.tagName("img"));
        driver.findElement(By.tagName("span"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.tagName("h3"));
        driver.findElement(By.tagName("script"));
        List<WebElement> elements2 = driver.findElements(By.tagName("img"));
        System.out.println(elements2.size());
        List<WebElement> elements3 = driver.findElements(By.tagName("div"));
        System.out.println(elements3.size());


    }

    @Test
    public void findElementById(){
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("pollanswers-1"));
        driver.findElement(By.id("pollanswers-2"));
        driver.findElement(By.id("pollanswers-3"));
        driver.findElement(By.id("pollanswers-4"));
        driver.findElement(By.id("vote-poll-1"));
        driver.findElement(By.id("newsletter-subscribe-button"));
        driver.findElement(By.id("newsletter-email"));
        driver.findElement(By.id("bar-notification"));
        driver.findElement(By.id("topcartlink"));


    }
    @Test
    public void findElementByClassName(){
       driver.findElement(By.className("nivo-imageLink"));
       driver.findElement(By.className("nivo-nextNav"));
       driver.findElement(By.className("nivo-prevNav"));
       driver.findElement(By.className("ico-register"));
       driver.findElement(By.className("ico-login"));
       driver.findElement(By.className("cart-label"));
        driver.findElement(By.className("ico-wishlist"));
        driver.findElement(By.className("top-menu-triangle"));
        driver.findElement(By.className("sublist"));
        driver.findElement(By.className("inactive"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
}
}
