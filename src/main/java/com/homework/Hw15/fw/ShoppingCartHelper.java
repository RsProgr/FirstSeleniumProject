package com.homework.Hw15.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCartHelper extends BaseHelper{

    public ShoppingCartHelper(WebDriver driver) {
        super(driver);
    }

    public void clearCart() {
        click(By.cssSelector(".cart-label")); // Открываем корзину


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
