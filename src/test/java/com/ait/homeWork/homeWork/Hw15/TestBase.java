package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//*[@class='topic-html-content-header']"));
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty(); // Оптимизировано
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) { // Проверка на пустую строку
            click(locator);
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clearCart() {
        click(By.cssSelector(".cart-label")); // Открываем корзину


    }

    public void login() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "xor19@list.ru");
        type(By.name("Password"), "Qwerty12345!");
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementPresent(By.xpath("//*[@type='button']"));
    }

    public void fillRegistrationLoginForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isSignOutButtonPresent() { // Исправлено имя метода
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void verifyItemAddedToCart() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".cart-qty")), "Item was not added to cart");
    }

    public void clickAddItemToCart() {
        click(By.cssSelector("#add-to-cart-button-31"));
    }

    public void clickProductPage() {
        click(By.cssSelector("img[src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
    }

    public void verifyCartIsEmpty() {
        Assert.assertEquals(getEmptyCartMessage(), "Your Shopping Cart is empty!", "Cart should be empty after removing an item");
    }

    private String getEmptyCartMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Your Shopping Cart is empty')]")));
        return emptyCartMessage.getText();
    }

    public void clickUpdateShoppingCartButton() {
        click(By.cssSelector("[name='updatecart']"));
    }

    public void clickCheckbox() { // Исправлено имя метода
        click(By.cssSelector("[type=checkbox]"));
    }

    public void clickShoppingCartLink() {
        click(By.cssSelector(".cart-label"));
    }
}