package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase{
    @Test
    public void addItemToCartTest() {
        login();
        click(By.cssSelector("img[src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
        click(By.cssSelector("#add-to-cart-button-31"));
        Assert.assertEquals(isElementPresent(By.cssSelector(".cart-qty")), true);
    }
    @Test
    public void removeProductFromCart(){
        login();
        click(By.cssSelector(".cart-label"));
        click(By.cssSelector("[type=checkbox]"));
        click(By.cssSelector("[name='updatecart']"));
    }

    @AfterMethod(enabled = false)
    public void clearCart() {
        click(By.cssSelector("[href='/cart']"));
        if (isElementPresent(By.name("removefromcart"))) {
            click(By.name("removefromcart"));
            click(By.name("updatecart"));
        }
    }

    private void login() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "xor19@list.ru");
        type(By.name("Password"), "Qwerty12345!");
        click(By.xpath("//*[@class='button-1 login-button']"));
    }


}
