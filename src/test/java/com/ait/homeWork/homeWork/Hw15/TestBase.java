package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
    public boolean isHomeComponentPresent(){
        return isElementPresent(By.xpath("//*[@class='topic-html-content-header']"));
    }
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void clearCart() {
        click(By.cssSelector(".cart-label")); // Открываем корзину
        if (isElementPresent(By.name("removefromcart"))) {
            click(By.name("removefromcart")); // Удаляем товар
            click(By.name("updatecart")); // Обновляем корзину
        }
    }
    public void login() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "xor19@list.ru");
        type(By.name("Password"), "Qwerty12345!");
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public void isSignUpButtonPresent() {
        Assert.assertEquals(isElementPresent(By.xpath("//*[@type='button']")), true, "Registration failed!");
    }

    public void fillRegistrationLoginForm(String firstName, String lastName, String email, String password, String confirmPassword) {

        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), confirmPassword);

        clickOnRegistrationButton();
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void isSignOuButtonPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")), "Logout button is missing, login might have failed!");
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    public void fillRegistrationLoginForm(String email, String password) {
        type(By.name("Email"), email);
        type(By.name("Password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }
}