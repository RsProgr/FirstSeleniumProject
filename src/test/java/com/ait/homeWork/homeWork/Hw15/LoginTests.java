package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {

        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "xor19@list.ru");
        type(By.name("Password"), "Qwerty12345!");
        click(By.xpath("//input[@class='button-1 login-button']"));

        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")), "Logout button is missing, login might have failed!");
    }
}